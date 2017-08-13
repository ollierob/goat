package net.ollie.goat.numeric.fraction;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.numeric.BigDecimals;
import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.numeric.percentage.FractionalPercentage;
import net.ollie.goat.numeric.percentage.Percentage;

/**
 *
 * @author Ollie
 */
@XmlRootElement
public class DecimalFraction
        extends Number
        implements Numeric.Summable<DecimalFraction>, Externalizable {

    private static final long serialVersionUID = 1L;

    public static final DecimalFraction MINUS_ONE = DecimalFraction.of(-1, 1);
    public static final DecimalFraction ZERO = new DecimalFraction(BigDecimal.ZERO, BigDecimal.ONE);

    public static DecimalFraction of(final long numerator, final long denominator) {
        return of(BigDecimal.valueOf(numerator), BigDecimal.valueOf(denominator));
    }

    public static DecimalFraction of(final Number numerator, final Number denominator) {
        if (numerator instanceof DecimalFraction) {
            return ((DecimalFraction) numerator).over(denominator);
        }
        if (denominator instanceof DecimalFraction) {
            return ((DecimalFraction) denominator).inverse().times(numerator);
        }
        return of(BigDecimals.toBigDecimal(numerator), BigDecimals.toBigDecimal(denominator));
    }

    public static DecimalFraction of(final BigDecimal numerator, final BigDecimal denominator) {
        if (numerator.signum() == 0) {
            return ZERO;
        }
        return denominator.signum() < 0
                ? new DecimalFraction(numerator.negate(), denominator.negate())
                : new DecimalFraction(numerator, denominator);
    }

    public static DecimalFraction of(final Number number) {
        return number instanceof DecimalFraction
                ? (DecimalFraction) number
                : of(BigDecimals.toBigDecimal(number));
    }

    public static DecimalFraction of(final BigDecimal d) {
        return new DecimalFraction(d, BigDecimal.ONE);
    }

    @XmlAttribute(name = "numerator")
    private BigDecimal numerator;

    @XmlAttribute(name = "denominator")
    private BigDecimal denominator;

    @Deprecated
    DecimalFraction() {
    }

    DecimalFraction(final BigDecimal numerator, final BigDecimal denominator) {
        if (denominator.signum() == 0) {
            throw new ArithmeticException(numerator + "/" + denominator);
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public BigDecimal numerator() {
        return numerator;
    }

    public BigDecimal denominator() {
        return denominator;
    }

    @Override
    public boolean isZero() {
        return numerator.signum() == 0;
    }

    public boolean isNegative() {
        return !this.isZero()
                && numerator.signum() != denominator.signum();
    }

    public DecimalFraction plus(@Nonnull final Number number) {
        return number instanceof DecimalFraction
                ? this.plus((DecimalFraction) number)
                : this.plus(BigDecimals.toBigDecimal(number));
    }

    @CheckReturnValue
    public DecimalFraction plus(@Nonnull final BigDecimal bd) {
        return of(numerator.add(bd.multiply(denominator)), denominator);
    }

    @Override
    public DecimalFraction plus(final DecimalFraction that) {
        return of(
                this.numerator.multiply(that.denominator).add(that.numerator.multiply(this.denominator)),
                this.denominator.multiply(that.denominator));
    }

    @Override
    public DecimalFraction minus(final DecimalFraction that) {
        return of(
                this.numerator.multiply(that.denominator).subtract(that.numerator.multiply(this.denominator)),
                this.denominator.multiply(that.denominator));
    }

    @Override
    public DecimalFraction negate() {
        return of(numerator.negate(), denominator);
    }

    @Override
    @Deprecated
    public DecimalFraction times(final Number that, final RoundingMode rounding) {
        return this.times(that);
    }

    @Override
    public DecimalFraction times(final Number number) {
        return number instanceof DecimalFraction
                ? this.times((DecimalFraction) number)
                : this.times(BigDecimals.toBigDecimal(number));
    }

    public DecimalFraction times(final BigDecimal decimal) {
        return of(numerator.multiply(decimal), denominator);
    }

    public DecimalFraction times(final DecimalFraction that) {
        return of(numerator.multiply(that.numerator), denominator.multiply(that.denominator));
    }

    public DecimalFraction over(final Number number) {
        return number instanceof DecimalFraction
                ? this.over((DecimalFraction) number)
                : this.over(BigDecimals.toBigDecimal(number));
    }

    public DecimalFraction over(final BigDecimal decimal) {
        return of(numerator, denominator.multiply(decimal));
    }

    public DecimalFraction over(final DecimalFraction that) {
        return this.times(that.inverse());
    }

    public DecimalFraction abs() {
        return this.isNegative()
                ? of(numerator.abs(), denominator.abs())
                : this;
    }

    public DecimalFraction inverse() {
        return of(denominator, numerator);
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return numerator.divide(denominator, context);
    }

    @Override
    public int intValue() {
        return this.decimalValue(MathContext.DECIMAL32).intValue();
    }

    @Override
    public long longValue() {
        return this.decimalValue(MathContext.DECIMAL32).longValue();
    }

    @Override
    public float floatValue() {
        return this.decimalValue(MathContext.DECIMAL32).floatValue();
    }

    @Override
    public double doubleValue() {
        return this.decimalValue(MathContext.DECIMAL64).doubleValue();
    }

    public boolean isReduced() {
        final BigInteger n = numerator.unscaledValue();
        final BigInteger d = denominator.unscaledValue();
        final BigInteger gcd = n.gcd(d);
        return gcd.compareTo(BigInteger.ONE) == 0;
    }

    public Percentage toPercentage() {
        return new FractionalPercentage(this);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.doubleValue());
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof DecimalFraction
                && this.valuesEqual((DecimalFraction) obj);
    }

    @Override
    public boolean valuesEqual(final DecimalFraction that) {
        return this.minus(that).isZero();
    }

    @Override
    public int compareTo(final DecimalFraction that) {
        final BigDecimal n1 = this.numerator.multiply(that.denominator);
        final BigDecimal n2 = that.numerator.multiply(this.denominator);
        return n1.compareTo(n2);
    }

    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(numerator);
        out.writeObject(denominator);
    }

    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        numerator = (BigDecimal) in.readObject();
        denominator = (BigDecimal) in.readObject();
    }

}
