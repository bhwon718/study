package theater;

/**
 * 관객
 */
public class Audience {
    private final Bag bag; //가방

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        bag.setTicket(ticket);
        if (bag.hasInvitation()) {
            return 0L;
        } else {
            // 관람객에 가방에서 티켓 금액을 차감
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
