package net.ollie.goat.temporal.date.count;

/**
 *
 * @author Ollie
 */
public interface DateArithmetic extends DayCount, YearCount {

    DateArithmetic ACT_ACT = ActualActualAccrualFactor.ACT_ACT;
    DateArithmetic ACT_360 = ActualFixedAccrualFactor.ACT_360;
    DateArithmetic ACT_365 = ActualFixedAccrualFactor.ACT_365;

    static DateArithmetic of(final DayCount dayCount, final YearCount yearCount) {
        return new MixedAccrualFactor(dayCount, yearCount);
    }

}
