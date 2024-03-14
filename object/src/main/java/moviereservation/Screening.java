package moviereservation;

import java.time.LocalDateTime;

public class Screening {
    //영화
    private final Movie movie;

    //순번
    private final int sequence;

    //상영시간
    private final LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    /**
     * 상영시작시간 반환
     *
     * @return
     */
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    /**
     * 순번의 일치여부 검사
     *
     * @param sequence
     * @return
     */
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    /**
     * 기본요금 반환
     *
     * @return
     */
    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, caculateFee(audienceCount), audienceCount);
    }

    /**
     * 요금 계산
     *
     * @param audienceCount
     * @return
     */
    private Money caculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
