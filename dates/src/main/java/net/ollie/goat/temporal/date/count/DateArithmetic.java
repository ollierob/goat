package net.ollie.goat.temporal.date.count;

/**
 *
 * @author Ollie
 */
public interface DateArithmetic extends DayCount, YearCount {

    DateArithmetic ACT_ACT = ActualActualDateArithmetic.ACT_ACT;
    DateArithmetic ACT_360 = ActualFixedDateArithmetic.ACT_360;
    DateArithmetic ACT_365 = ActualFixedDateArithmetic.ACT_365;
    DateArithmetic THIRTY_360 = FixedFixedDateArithmetic.THIRTY_360;
    DateArithmetic THIRTY_365 = FixedFixedDateArithmetic.THIRTY_365;

    static DateArithmetic of(final DayCount dayCount, final YearCount yearCount) {
        return new MixedDateArithmetic(dayCount, yearCount);
    }

}
