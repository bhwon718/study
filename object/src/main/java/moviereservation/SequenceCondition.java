package moviereservation;

public class SequenceCondition implements DiscountCondition {

    private final int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isStatisfiedBy(Screening screening) {
        return screening.isSequence(this.sequence);
    }
}
