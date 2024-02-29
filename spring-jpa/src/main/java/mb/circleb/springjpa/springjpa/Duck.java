package mb.circleb.springjpa.springjpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Duck {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @PrePersist
    public void prePersist() {
        System.out.println("Duck.prePersist id=" + id);
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Duck.postPersist id=" + id);
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Duck.postLoad");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("Duck.preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("Duck.postRemove");
    }
}
