package mb.circleb.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)

    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.remove(orderItem);
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                ", member=" + member +
                '}';
    }
}
