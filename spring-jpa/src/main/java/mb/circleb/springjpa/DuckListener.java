package mb.circleb.springjpa;

import jakarta.persistence.*;

public class DuckListener {

    @PrePersist
    //특정 타입이 확실하면 대상 엔티티를 파라미터로 받을수 있다.
    public void prePersist(Duck duck) {
        System.out.println("Duck.prePersist id=" + duck.getId());
    }

    @PostPersist
    //특정 타입이 확실하면 대상 엔티티를 파라미터로 받을수 있다.
    public void postPersist(Duck duck) {

        System.out.println("Duck.postPersist id=" + duck.getId());
    }

    @PostLoad
    //특정 타입이 확실하면 대상 엔티티를 파라미터로 받을수 있다.
    public void postLoad(Duck duck) {
        System.out.println("Duck.postLoad");
    }

    @PreRemove
    //특정 타입이 확실하면 대상 엔티티를 파라미터로 받을수 있다.
    public void preRemove(Duck duck) {
        System.out.println("Duck.preRemove");
    }

    @PostRemove
    //특정 타입이 확실하면 대상 엔티티를 파라미터로 받을수 있다.
    public void postRemove(Duck duck) {
        System.out.println("Duck.postRemove");
    }

}
