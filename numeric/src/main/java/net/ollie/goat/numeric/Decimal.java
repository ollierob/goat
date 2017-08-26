package net.ollie.goat.numeric;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import net.ollie.goat.numeric.fraction.DecimalFraction;

/**
 * Fixed decimal number.
 *
 * @author ollie
 */
public class Decimal extends Number implements Numeric.Summable<Decimal> {

    private static final long serialVersionUID = 1L;
    private static final short SHORT_INT = 0;

    public static Decimal valueOf(final Number number) {
        if (number instanceof Decimal) {
            return (Decimal) number;
        }
        if (number instanceof BigDecimal) {
            return valueOf((BigDecimal) number);
        }
        return Numbers.isEffectiveIntegral(number)
                ? valueOf(number.longValue())
                : valueOf(BigDecimal.valueOf(number.doubleValue()));
    }

    public static Decimal valueOf(final long value) {
        return new Decimal(value, SHORT_INT);
    }

    public static Decimal valueOf(final BigDecimal decimal) {
        return new Decimal(decimal.doubleValue(), min(decimal.scale(), Short.MAX_VALUE));
    }

    public static Decimal integer(final double value) {
        return new Decimal((int) value, (short) 0);
    }

    private static short min(final int s1, final short s2) {
        return s1 < s2 ? (short) s1 : s2;
    }

    private final double value;
    private final short dp;

    Decimal(final double value, final short dp) {
        this.value = value;
        this.dp = dp;
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) this.doubleValue();
    }

    @Override
    public double doubleValue() {
        return Math.round(value * Math.pow(10, dp)) / Math.pow(10, dp);
    }

    @Override
    public BigDecimal decimalValue() {
        return new BigDecimal(value).setScale(dp);
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return new BigDecimal(value, context);
    }

    @Override
    public Decimal plus(final Decimal that) {
        return new Decimal(value + that.value, (short) Math.max(dp, that.dp));
    }

    @Override
    public Decimal negate() {
        return new Decimal(-value, dp);
    }

    @Override
    public Decimal times(final Number that, final RoundingMode rounding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Decimal over(final double value) {
        return new Decimal(this.value / value, dp);
    }

    @Override
    public Decimal reciprocal() {
        return new Decimal(1 / value, dp);
    }

    public DecimalFraction over(final Number denominator) {
        return DecimalFraction.of(this, denominator);
    }

    @Override
    public String toString() {
        return this.decimalValue().toPlainString();
    }

}
