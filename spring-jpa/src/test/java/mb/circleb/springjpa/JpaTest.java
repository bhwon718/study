package mb.circleb.springjpa;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Subgraph;
import jakarta.transaction.Transactional;
import org.hibernate.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@DataJpaTest
@Transactional
@SpringBootTest
@Commit
public class JpaTest {

    @Autowired
    EntityManager em;

    @Test
    void init() {

    }

    @Test
    @Transactional
    void test() {

        Team team = new Team();
        System.out.println("before persist =" + team.getMemberList().getClass());
        em.persist(team);
        System.out.println("after persist =" + team.getMemberList().getClass());

        team.getMemberList().add(new Member());

        team.getMemberList().remove(new Member());

    }


    @Test
    @Transactional
    void event() {
        Duck duck = new Duck("오리");
        em.persist(duck);
        em.flush();
    }


    @Test
    void testEntityGraph() {

        Map<String, Object> hints = new HashMap();
        EntityGraph graph = em.getEntityGraph("Order.withAll");
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = em.find(Order.class, 1L, hints);
//        Order order = em.find(Order.class, 1L);

    }

    @Test
    void testEntityGraphJPql() {

        List<Order> orderList = em.createQuery("select o from Order o where o.id = :orderId", Order.class)
                .setParameter("orderId", 1L)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("Order.withAll"))
                .getResultList();


//        Order order = em.find(Order.class, 1L);

    }

    @Test
    void testEntityGraphDynamicCreate() {
        EntityGraph<Order> graph = em.createEntityGraph(Order.class);
        graph.addAttributeNodes("member");

        //서브그래프 동적생성
        Subgraph<OrderItem> subgraph = graph.addSubgraph("orderItemList");
        subgraph.addAttributeNodes("item");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = em.find(Order.class, 1L, hints);
    }


    @Test
    void testEntityManagerProxy() {
        Member member = new Member();
        member.setId(1L);
        member.setName("회원1");
        em.persist(member);
        em.flush();
        em.clear();

        Member refMember = em.getReference(Member.class, 1L);

        System.out.println("member Type=" + member.getClass());
        System.out.println("refMember Type=" + refMember.getClass());

        assertFalse(member == refMember);
        assertTrue(refMember instanceof Member);
        assertTrue(refMember instanceof Member);
    }

    @Test
    void testNPlus1() {
        Member member = em.find(Member.class, 1L);
    }

    @Test
    void testNPlus2() {
        LongStream.range(1L, 10L).forEach(v -> {
            Member member = new Member();
            member.setId(v);
            em.persist(member);
        });
        em.flush();
        em.clear();

        List<Member> memberList = em.createQuery("select m From Member m", Member.class)
                .getResultList();

    }

    @Test
    void testNPlus3() {
        LongStream.range(1L, 10L).forEach(v -> {
            Member member = new Member();
            member.setId(v);
            em.persist(member);
        });
        em.flush();
        em.clear();

        List<Member> memberList = em.createQuery("select m From Member m", Member.class)
                .getResultList();

        memberList.forEach(v -> v.getOrderList().size());

    }

    @Test
    void testNPlusSubSelect() {
        LongStream.range(1L, 10L).forEach(v -> {
            Member member = new Member();
            member.setId(v);
            em.persist(member);
        });
        em.flush();
        em.clear();


        List<Order> orderList = em.createQuery("select o from Order o", Order.class)
                .setHint("org.hibernate.readOnly", true)
                .getResultList();


    }

    @Test
    public void testJpaBatch() {
        IntStream.range(1, 100000).forEach(i -> {
            Item item = new Item("iten" + i);
            em.persist(item);

            // 100건마다 플러시와  영속성컨텍스트 초기화
//            if (i % 100 == 0) {
//                em.flush();
//                em.clear();
//            }
        });
        em.flush();
    }

    @Test
    void testJpaBatchPaging() {
        int pageSize = 100;
        for (int i = 0; i < 10; i++) {
            List<Item> itemList = em.createQuery("select i from Item i", Item.class)
                    .setFirstResult(i * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

            //비즈니스 로직 실행
            itemList.forEach(item -> {
                item.setName(item.getName() + "_1");
            });

            em.flush();
            em.clear();
        }
    }

    @Test
    void testHibernateScroll() {
        Session session = em.unwrap(Session.class);
        ScrollableResults<Item> scroll = session.createQuery("select i from Item i", Item.class)
                .setCacheMode(CacheMode.IGNORE) //2차 캐시 기능을 끈다.
                .scroll(ScrollMode.FORWARD_ONLY);

        int count = 0;
        while (scroll.next()) {
            Item item = scroll.get();
            item.setName(item.getName() + "_1");

            count++;
            if (count % 100 == 0) {
                session.flush();    //플러시
                session.clear();    //영속성 컨텍스트 초기화
            }
        }
        session.close();
    }

    @Test
    void testHibernateStatelessSession() {

        SessionFactory sessionFactory = em.unwrap(SessionFactory.class);
        StatelessSession session = sessionFactory.openStatelessSession();
        Transaction tx = session.beginTransaction();
        ScrollableResults scrollableResults = session.createQuery("select i from Item i", Item.class).scroll();

        while (scrollableResults.next()) {
            Item item = (Item) scrollableResults.get();
            item.setName(item.getName() + "_1");
            session.update(item);
        }

        tx.commit();
        session.close();
    }

    @Test
    void testHibernateHint() {
        Session session = em.unwrap(Session.class);
        List<Member> memberList = session.createQuery("select m from Member m", Member.class)
                .addQueryHint("FULL (MEMBER)")
                .list();
    }

    @Test
    @Commit
    void makeItem() {
        IntStream.range(1, 100).forEach(v -> {
            Item item = new Item((long) v, "상품명" + v);
            em.persist(item);
        });

    }


    @Test
    @Commit
    void testVersion() {

        Item item = em.find(Item.class, 1L, LockModeType.OPTIMISTIC);
        item.setName(UUID.randomUUID().toString());

        System.out.println("Item 2 : {}" + item);


    }

    @Test
    @Commit
    void testVersion2() {

        Item item = em.find(Item.class, 1L, LockModeType.OPTIMISTIC_FORCE_INCREMENT);

        item.setName(UUID.randomUUID().toString());


    }

}