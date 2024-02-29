package mb.circleb.springjpa.springjpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JpaTest {

    @Autowired
    EntityManager em;

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
    void event(){

        Duck duck = new Duck("오리");

        em.persist(duck);



    }



}
