package net.ollie.goat.temporal.date.days;

import java.math.RoundingMode;

import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.temporal.ChronoTemporal;

/**
 *
 * @author Ollie
 */
public interface Days extends ChronoTemporal, Numeric.Summable<Days> {

    @Override
    default Days plus(final Days that) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    default Days times(final Number that, final RoundingMode rounding) {
        throw new UnsupportedOperationException();
    }

    static Days of(final int days) {
        return IntegerDays.of(days);
    }

}
