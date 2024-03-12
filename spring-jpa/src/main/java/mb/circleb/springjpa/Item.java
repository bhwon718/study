package mb.circleb.springjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Item {

    @Id
    private Long id;

    @Version
    private int version;

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
