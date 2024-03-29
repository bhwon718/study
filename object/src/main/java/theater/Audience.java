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
       return bag.hold(ticket);
    }
}
