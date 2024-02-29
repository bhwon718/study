package mb.circleb.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
            logic(em);  //비즈니스 로직
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
        //update tb_item set price = 1001 where id = 1
        em.setFlushMode(FlushModeType.COMMIT);
        Item item = em.find(Item.class, 1L);

        item.setPrice(1000L);

        System.out.println("item 1 : " + item);
        System.out.println("item 1 : " + item.hashCode());


        em.flush(); //1 em.flush() 직접호출

        // FlushModeType.COMMIT 일경우 위에서 변경한 price 금액이 아직 DB에 반영되지 않았기때문에 데이터 가 조회 되지 않는다
        List<Item> itemList = em.createQuery("select i from Item i where i.price <= 1000", Item.class)
                                .setFlushMode(FlushModeType.AUTO) // setFlushMode  설정
                                .getResultList();

        System.out.println("item 2 : " + (!itemList.isEmpty() ? itemList.get(0) : null));
        System.out.println("item 2 : " + (!itemList.isEmpty() ? itemList.get(0).hashCode() : null));

    }


}

@Getter
@Setter
class SearchParam {
    private String name;
    private Long price;
}