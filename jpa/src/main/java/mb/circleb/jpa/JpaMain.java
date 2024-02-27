package mb.circleb.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            save(em);
            logic(em);  //비즈니스 로직
//            logic2(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void save(EntityManager em) {
        Team team = new Team();
        team.setName("팀등록");
        em.persist(team);
    }


    public static void logic(EntityManager em) {

//        String sql = "select m from Member  m inner join m.team t where m.name like '이름%'";
        String sql = "select t from Team t join fetch t.memberList where t.name like 'TEAM A'";
        List<Team> teamList = em.createQuery(sql, Team.class).getResultList();
        teamList.forEach(System.out::println);

    }

    public static void logic2(EntityManager em) {

        List<Member> memberList = em.createQuery("Select m From Member m where m.name = :name", Member.class)
                .setParameter("name", "이름1")
                .setFirstResult(10)
                .setMaxResults(20)
                .getResultList();
        memberList.forEach(System.out::println);
    }


}
