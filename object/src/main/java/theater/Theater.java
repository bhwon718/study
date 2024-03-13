package theater;

/**
 * 소극장
 */
public class Theater {
    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /**
     * 입장...
     *
     * @param audience
     */
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
