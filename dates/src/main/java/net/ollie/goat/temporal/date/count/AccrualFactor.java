package net.ollie.goat.temporal.date.count;

/**
 *
 * @author Ollie
 */
public interface AccrualFactor extends DayCount, YearCount {

    AccrualFactor ACT_ACT = ActualActualAccrualFactor.ACT_ACT;
    AccrualFactor ACT_365 = ActualFixedAccrualFactor.ACT_365;

    static AccrualFactor of(final DayCount dayCount, final YearCount yearCount) {
        return new MixedAccrualFactor(dayCount, yearCount);
    }

}
