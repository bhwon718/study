package theater;

/**
 * 관객 가방
 */
public class Bag {
    private final Invitation invitation;
    private Long amount;
    private Ticket ticket;

    public Bag(Long amount) {
        this(amount, null);
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    /**
     * 초대여부 확인
     *
     * @return
     */
    private boolean hasInvitation() {
        return invitation != null;
    }

    /**
     * 티켓 소유 여부 확인
     *
     * @return
     */
    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 현금을 감소 시킨다
     *
     * @param amount
     */
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public Long hold(Ticket ticket) {

        setTicket(ticket);
        if (hasInvitation()) {
            return 0L;
        } else {
            // 관람객에 가방에서 티켓 금액을 차감
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}
