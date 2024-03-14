package moviereservation;

public class AmountDiscountPolicy implements DiscountPolicy {
    private final Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        this.discountAmount = discountAmount;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return this.discountAmount;
    }
}
