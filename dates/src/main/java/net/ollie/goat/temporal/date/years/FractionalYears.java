package net.ollie.goat.temporal.date.years;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Period;

import javax.xml.bind.annotation.XmlElement;

import net.ollie.goat.numeric.Numbers;

import org.apache.commons.math3.fraction.Fraction;

/**
 *
 * @author Ollie
 */
public class FractionalYears implements Years {

    private static final long serialVersionUID = 1L;

    public static final FractionalYears ONE = of(1, 1);

    public static FractionalYears of(final int numerator, final int denominator) {
        return new FractionalYears(new Fraction(numerator, denominator));
    }

    @XmlElement(name = "years") //FIXME not marshalable
    private Fraction years;

    @Deprecated
    FractionalYears() {
    }

    public FractionalYears(final Fraction years) {
        this.years = years;
    }

    @Override
    public Years plus(final Years that) {
        return that instanceof FractionalYears
                ? this.plus((FractionalYears) that)
                : new DoubleYears(this.years.doubleValue() + that.doubleValue());
    }

    public FractionalYears plus(final FractionalYears that) {
        return new FractionalYears(this.years.add(that.years));
    }

    @Override
    public Years times(final Number that, final RoundingMode rounding) {
        final double years = this.years.doubleValue() * that.doubleValue();
        return Years.of(Numbers.round(years, rounding));
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(years.doubleValue()).round(context);
    }

    @Override
    public Period toPeriod(final double daysPerYear) {
        final double total = years.doubleValue();
        final int wholeYears = (int) total;
        final int wholeDays = (int) (daysPerYear * (total - wholeYears));
        return Period.of(wholeYears, 0, wholeDays);
    }

}
