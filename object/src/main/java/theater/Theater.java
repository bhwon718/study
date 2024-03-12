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

        Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        if (audience.getBag().hasInvitation()) {

        } else {
            // 초대장이 없다면 티켓을 판매해야 한다.
            // 1. 관람객에 가방에서 티켓 금액을 차감후
            audience.getBag().minusAmount(ticket.getFee());
            // 2. 매표소에 금액을 증가 시킨다.
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        }
        // 관람객에 가방안에 티켓을 넣어준다.
        audience.getBag().setTicket(ticket);
    }
}
