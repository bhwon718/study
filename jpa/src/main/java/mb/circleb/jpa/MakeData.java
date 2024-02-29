package mb.circleb.jpa;


import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static mb.circleb.jpa.QItem.item;

/**
 * @author holyeye
 */
public class MakeData {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            makeTestData(em);
//            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {
        JPAQuery<Item> q = new JPAQuery(em);
        List<Item> itemList = q.from(item)
                .groupBy(item.price)
                .having(item.price.gt(1000))
                .fetch();


        itemList.forEach(System.out::println);
    }


    public static void makeTestData(EntityManager em) {
        createItem(em);
        createMember(em);

        createOrder(em);


    }

    public static void createItem(EntityManager em) {
        Random random = new Random();

        IntStream.range(1, 1000).forEach(value -> {

                    Item item = new Item();
                    item.setName("상품".concat(String.valueOf(value)));
                    item.setPrice(random.nextLong(100000));
                    em.persist(item);
                }

        );
    }

    public static void createMember(EntityManager em) {
        IntStream.range(1, 10).forEach(value -> {

                    Member member = new Member();
                    member.setName("회원".concat(String.valueOf(value)));
                    em.persist(member);
                }

        );
    }

    public static void createOrder(EntityManager em) {

//        Random random = new Random();

        IntStream.range(1, 50).forEach(orderNo -> {

            Random random = new Random();

            Order order = new Order();
            order.setMember(em.find(Member.class, random.nextLong(1,10)));


            int itemCount = random.nextInt(10);
            IntStream.range(1, itemCount).forEach(v -> {

                Item item = em.find(Item.class, random.nextLong(1,100));

                OrderItem orderItem = new OrderItem();
                orderItem.setItem(item);
                orderItem.setQty(random.nextInt(10));


                order.addOrderItem(orderItem);
            });

            em.persist(order);

        });
    }

}
