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

    private static final IntegerDays[] minusOneToTen = new IntegerDays[12];

    static {
        for (int i = -1; i < minusOneToTen.length; i++) {
            minusOneToTen[i + 1] = new IntegerDays(i);
        }
    }

    public static IntegerDays of(final int days) {
        return days >= 0 && days < minusOneToTen.length
                ? minusOneToTen[days + 1]
                : new IntegerDays(days);
    }

    private final int days;

    protected IntegerDays(final int numDays) {
        this.days = numDays;
    }

    public int value() {
        return days;
    }

    @Override
    public Period toPeriod() {
        return Period.ofDays(days);
    }

    @Override
    public IntegerDays negate() {
        return of(-days);
    }

    public IntegerDays times(final int that, final RoundingMode rounding) {
        return of(Math.multiplyExact(days, that));
    }

    public IntegerDays over(final Number that, final RoundingMode rounding) {
        return of(Numbers.round(days / that.doubleValue(), rounding));
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(days);
    }

    @Override
    public String toString() {
        return days + " days";
    }

}
