package net.ollie.goat.temporal.date.count;

import net.ollie.goat.temporal.date.years.FractionalYears;
import net.ollie.goat.temporal.date.years.Years;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ollie
 */
public enum ActualFixedDateArithmetic implements DateArithmetic, ActualDayCount {

    ACT_360(360),
    ACT_364(364),
    ACT_365(365);

    private final int daysPerYear;

    private ActualFixedDateArithmetic(int daysPerYear) {
        this.daysPerYear = daysPerYear;
    }

    @Override
    public Period between(final LocalDate startInclusive, final LocalDate endExclusive) {
        final int days = this.daysBetween(startInclusive, endExclusive);
        return Period.of(days % daysPerYear, 0, days / daysPerYear);
    }

    @Override
    public Years yearsBetween(final LocalDate startInclusive, final LocalDate endExclusive) {
        return FractionalYears.of(this.daysBetween(startInclusive, endExclusive), daysPerYear);
    }

}
