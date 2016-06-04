package net.ollie.goat.temporal.date.years;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Period;

import javax.xml.bind.annotation.XmlAttribute;

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
    public Years times(final Number that, final RoundingMode rounding) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    public BigDecimal decimalValue(final MathContext context) {
        throw new UnsupportedOperationException(); //TODO
    }

}
