package net.ollie.goat.temporal.date.months;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.temporal.ChronoTemporal;
import net.ollie.goat.temporal.date.years.Years;

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

    default Optional<Years> normalize() {
        final BigDecimal value = this.decimalValue();
        if (value.scale() == 0) {
            final int i = value.intValueExact();
            return i % 12 == 0
                    ? Optional.of(Years.of(i / 12))
                    : Optional.empty();
        }
        return Optional.empty();
    }

    static IntegerMonths of(final int months) {
        return IntegerMonths.of(months);
    }

}
