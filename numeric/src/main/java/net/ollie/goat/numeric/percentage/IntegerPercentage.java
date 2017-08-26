package net.ollie.goat.numeric.percentage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author ollie
 */
@XmlRootElement
public class IntegerPercentage extends Percentage {

    public static final IntegerPercentage ZERO = new IntegerPercentage(0);

    public static IntegerPercentage of(final long value) {
        return value == 0
                ? ZERO
                : new IntegerPercentage(value);
    }

    @XmlValue
    private long value;

    @Deprecated
    IntegerPercentage() {
    }

    IntegerPercentage(final long value) {
        this.value = value;
    }

    @Override
    public boolean isNegative() {
        return value < 0;
    }

    @Override
    public Percentage reciprocal() {
        return FractionalPercentage.of(1, value);
    }

    @Override
    public int intValue() {
        return Math.toIntExact(value);
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public Percentage plus(final Percentage that) {
        return that instanceof IntegerPercentage
                ? this.plus((IntegerPercentage) that)
                : super.plus(that);
    }

    public IntegerPercentage plus(final IntegerPercentage that) {
        return of(Math.addExact(value, that.value));
    }

    @Override
    public Percentage times(final Number that, final RoundingMode rounding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IntegerPercentage times(final long that) {
        return of(Math.multiplyExact(value, that));
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(value);
    }

}
