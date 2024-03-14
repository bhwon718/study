package moviereservation;

public interface DiscountCondition {
    boolean isStatisfiedBy(Screening screening);
}
