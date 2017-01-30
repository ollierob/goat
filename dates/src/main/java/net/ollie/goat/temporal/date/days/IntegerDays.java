package net.ollie.goat.temporal.date.days;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import net.ollie.goat.numeric.Numbers;

/**
 *
 * @author Ollie
 */
public class IntegerDays implements Days {

    private static final long serialVersionUID = 1L;

    private static final IntegerDays[] zeroToTen = new IntegerDays[11];

    static {
        for (int i = 0; i < zeroToTen.length; i++) {
            zeroToTen[i] = new IntegerDays(i);
        }
    }

    public static IntegerDays of(final int days) {
        return days >= 0 && days < zeroToTen.length
                ? zeroToTen[days]
                : new IntegerDays(days);
    }

    private final int numDays;

    protected IntegerDays(final int numDays) {
        this.numDays = numDays;
    }

    public int value() {
        return numDays;
    }

    @Override
    public Period toPeriod() {
        return Period.ofDays(numDays);
    }

    @Override
    public IntegerDays negate() {
        return of(-numDays);
    }

    public IntegerDays times(final int that, final RoundingMode rounding) {
        return of(numDays * that);
    }

    public IntegerDays over(final Number that, final RoundingMode rounding) {
        return of(Numbers.round(numDays / that.doubleValue(), rounding));
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(numDays);
    }

    @Override
    public boolean isSupported(final ChronoUnit unit) {
        switch (unit) {
            case HALF_DAYS:
            case DAYS:
            case WEEKS:
                return true;
            default:
                return false;
        }
    }

    @Override
    public Temporal plus(long amountToAdd, ChronoUnit unit) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    public boolean isSupported(final ChronoField field) {
        return false;
    }

    @Override
    public long getLong(final ChronoField field) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    public String toString() {
        return numDays + " days";
    }

}
