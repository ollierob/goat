package net.ollie.goat.numeric;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import net.ollie.goat.numeric.fraction.BigDecimalFraction;

/**
 * Fixed decimal number.
 *
 * @author ollie
 */
public class SmallDecimal extends Number implements Numeric.Summable<SmallDecimal> {

    private static final long serialVersionUID = 1L;
    private static final short SHORT_INT = 0;

    public static SmallDecimal valueOf(final Number number) {
        if (number instanceof SmallDecimal) {
            return (SmallDecimal) number;
        }
        if (number instanceof BigDecimal) {
            return valueOf((BigDecimal) number);
        }
        return Numbers.isEffectiveIntegral(number)
                ? valueOf(number.longValue())
                : valueOf(BigDecimal.valueOf(number.doubleValue()));
    }

    public static SmallDecimal valueOf(final long value) {
        return new SmallDecimal(value, SHORT_INT);
    }

    public static SmallDecimal valueOf(final BigDecimal decimal) {
        return new SmallDecimal(decimal.doubleValue(), min(decimal.scale(), Short.MAX_VALUE));
    }

    public static SmallDecimal integer(final double value) {
        return new SmallDecimal((int) value, (short) 0);
    }

    private static short min(final int s1, final short s2) {
        return s1 < s2 ? (short) s1 : s2;
    }

    private final double value;
    private final short dp;

    SmallDecimal(final double value, final short dp) {
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
    public SmallDecimal plus(final SmallDecimal that) {
        return new SmallDecimal(value + that.value, (short) Math.max(dp, that.dp));
    }

    @Override
    public SmallDecimal negate() {
        return new SmallDecimal(-value, dp);
    }

    @Override
    public SmallDecimal times(final Number that, final RoundingMode rounding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SmallDecimal over(final double value) {
        return new SmallDecimal(this.value / value, dp);
    }

    @Override
    public SmallDecimal reciprocal() {
        return new SmallDecimal(1 / value, dp);
    }

    public BigDecimalFraction over(final Number denominator) {
        return BigDecimalFraction.of(this, denominator);
    }

    @Override
    public String toString() {
        return this.decimalValue().toPlainString();
    }

}
