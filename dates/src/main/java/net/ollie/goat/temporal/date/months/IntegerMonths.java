package net.ollie.goat.temporal.date.months;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import net.ollie.goat.optionals.Either;
import net.ollie.goat.temporal.date.years.IntegerYears;

/**
 *
 * @author ollie
 */
public class IntegerMonths implements Months {

    private static final long serialVersionUID = 1L;

    public static Either<IntegerMonths, IntegerYears> of(final int months) {
        return months % 12 == 0
                ? Either.right(IntegerYears.of(months / 12))
                : Either.left(ofNormalized(months));
    }

    private static IntegerMonths ofNormalized(final int months) {
        return new IntegerMonths(months);
    }

    private final int months;

    protected IntegerMonths(final int amount) {
        this.months = amount;
    }

    @Override
    public Period toPeriod() {
        return Period.ofMonths(months);
    }

    @Override
    public boolean isSupported(final ChronoUnit unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Temporal plus(long amountToAdd, ChronoUnit unit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSupported(final ChronoField field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getLong(final ChronoField field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(months);
    }

    @Override
    public Months plus(final Months that) {
        return that instanceof IntegerMonths
                ? this.plus((IntegerMonths) that)
                : Months.super.plus(that);
    }

    public IntegerMonths plus(final IntegerMonths that) {
        return ofNormalized(months + that.months);
    }

    @Override
    public IntegerMonths negate() {
        return ofNormalized(-months);
    }

    public IntegerMonths times(final int that) {
        return ofNormalized(Math.multiplyExact(months, that));
    }

}
