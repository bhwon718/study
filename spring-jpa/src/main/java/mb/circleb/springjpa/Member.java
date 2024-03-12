package mb.circleb.springjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Member {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Order> orderList = new ArrayList<>();

}
