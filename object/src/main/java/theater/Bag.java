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
    public boolean hasInvitation() {
        return invitation != null;
    }

    /**
     * 티켓 소유 여부 확인
     *
     * @return
     */
    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 현금을 감소 시킨다
     *
     * @param amount
     */
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /**
     * 현금을 증가시킨다.
     *
     * @param amount
     */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
