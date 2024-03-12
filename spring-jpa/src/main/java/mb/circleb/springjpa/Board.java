package mb.circleb.springjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Version
    private Integer version;
}
