package net.ollie.goat.numeric.percentage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.numeric.fraction.DecimalFraction;

/**
 *
 * @author ollie
 */
@XmlRootElement
public class FractionalPercentage extends Percentage {

    private static final long serialVersionUID = 1L;

    public static Percentage of(final long numerator, final long denominator) {
        final DecimalFraction fraction = DecimalFraction.of(numerator, denominator);
        return fraction.isZero()
                ? zero()
                : new FractionalPercentage(fraction);
    }

    public static Percentage of(final Number numerator, final Number denominator) {
        final DecimalFraction fraction = DecimalFraction.of(numerator, denominator);
        return fraction.isZero()
                ? Percentage.zero()
                : new FractionalPercentage(fraction);
    }

    @XmlElement(name = "fraction")
    private DecimalFraction fraction;

    @Deprecated
    FractionalPercentage() {
    }

    public FractionalPercentage(final DecimalFraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public boolean isNegative() {
        return fraction.isNegative();
    }

    @Override
    public FractionalPercentage inverse() {
        return new FractionalPercentage(fraction.inverse());
    }

    @Override
    public int intValue() {
        return fraction.intValue();
    }

    @Override
    public long longValue() {
        return fraction.longValue();
    }

    @Override
    public float floatValue() {
        return fraction.floatValue();
    }

    @Override
    public double doubleValue() {
        return fraction.doubleValue();
    }

    @Override
    public Percentage times(Number that, RoundingMode rounding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal decimalValue() {
        return fraction.decimalValue();
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return fraction.decimalValue(context);
    }

}
