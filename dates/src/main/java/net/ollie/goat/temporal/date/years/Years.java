package net.ollie.goat.temporal.date.years;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import javax.annotation.Nonnull;

import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.temporal.ChronoTemporal;
import net.ollie.goat.temporal.date.Dates;

/**
 *
 * @author ollie
 */
public interface Years extends ChronoTemporal, Comparable<Years>, Numeric.Summable<Years> {

    Years ZERO = IntegerYears.ZERO;
    Years ONE = IntegerYears.ONE;

    Period toPeriod(double daysPerYear);

    @Override
    default Period toPeriod() {
        return this.toPeriod(Dates.DAYS_PER_YEAR);
    }

    default int round(final MathContext context) {
        return this.decimalValue(context).intValue();
    }

    @Override
    default BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(Dates.approximateLength(this.toPeriod()));
    }

    @Nonnull
    default LocalDate addTo(final LocalDate date) {
        return date.plus(this.toPeriod());
    }

    @Override
    default Years plus(final Years that) {
        return new PeriodYears(this.toPeriod().plus(that.toPeriod()));
    }

    @Override
    default Years times(final Number that, final RoundingMode rounding) {
        return of(this.doubleValue() * that.doubleValue());
    }

    @Override
    default boolean isSupported(final ChronoUnit unit) {
        switch (unit) {
            case YEARS:
            case DECADES:
            case CENTURIES:
            case MILLENNIA:
            case ERAS:
                return true;
            default:
                return false;
        }
    }

    @Override
    default Years plus(final long amountToAdd, final ChronoUnit unit) {
        final int unitsOfYears;
        switch (unit) {
            case YEARS:
                unitsOfYears = 1;
                break;
            case DECADES:
                unitsOfYears = 10;
                break;
            case CENTURIES:
                unitsOfYears = 100;
                break;
            case MILLENNIA:
                unitsOfYears = 1000;
                break;
            case ERAS:
                unitsOfYears = 1_000_000_000;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return this.plus(Years.of(amountToAdd * unitsOfYears));
    }

    @Override
    default boolean isSupported(final ChronoField field) {
        switch (field) {
            case YEAR:
                return true;
            default:
                return false;
        }
    }

    @Override
    default long getLong(final ChronoField field) {
        switch (field) {
            case YEAR:
                return this.decimalValue().longValue();
        }
        throw new UnsupportedOperationException(); //TODO
    }

    static IntegerYears of(final int years) {
        return IntegerYears.of(years);
    }

    static Years of(final long years) {
        return of(Math.toIntExact(years));
    }

    static DoubleYears of(final double years) {
        return new DoubleYears(years);
    }

    static Years of(Period period) {
        period = period.normalized();
        return period.getDays() == 0 && period.getMonths() == 0
                ? of(period.getMonths())
                : new PeriodYears(period);
    }

}
