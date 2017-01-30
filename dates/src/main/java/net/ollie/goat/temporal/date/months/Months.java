package net.ollie.goat.temporal.date.months;

import java.math.RoundingMode;

import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.temporal.ChronoTemporal;

/**
 *
 * @author ollie
 */
public interface Months extends ChronoTemporal, Numeric.Summable<Months> {

    @Override
    default Months plus(final Months that) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    default Months times(Number that, RoundingMode rounding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
