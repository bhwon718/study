package mb.circleb.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private long id;
    private String orderer;
    private long amount;

    public OrderDTO(long id, String orderer, long amount) {
        this.id = id;
        this.orderer = orderer;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", orderer='" + orderer + '\'' +
                ", amount=" + amount +
                '}';
    }
}
