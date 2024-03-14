package moviereservation;

public class PercentDiscountPolicy implements DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        this.percent = percent;
    }


    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(this.percent);
    }
}
