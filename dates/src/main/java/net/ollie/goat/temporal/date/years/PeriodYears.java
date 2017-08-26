package net.ollie.goat.temporal.date.years;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Period;

import javax.xml.bind.annotation.XmlAttribute;

import net.ollie.goat.temporal.date.Periods;

/**
 *
 * @author Ollie
 */
public class PeriodYears implements Years {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "period")
    private Period period;

    @Deprecated
    PeriodYears() {
    }

    public PeriodYears(final Period period) {
        this.period = period;
    }

    @Override
    public Period period() {
        return period;
    }

    @Override
    public Period toPeriod(final double daysPerYear) {
        return period;
    }

    @Override
    public double doubleValue() {
        return Periods.approximateLength(period);
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(this.doubleValue()).round(context);
    }

    @Override
    public Years reciprocal() {
        return new DoubleYears(1 / doubleValue());
    }

}
