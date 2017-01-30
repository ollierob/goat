package net.ollie.goat.temporal.date.years;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Period;

import javax.xml.bind.annotation.XmlAttribute;

import net.ollie.goat.temporal.date.Dates;

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
    public Period toPeriod() {
        return period;
    }

    @Override
    public Period toPeriod(final double daysPerYear) {
        return period;
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        return BigDecimal.valueOf(Dates.approximateLength(period)).round(context);
    }

}
