package net.ollie.goat.temporal.date.days;

import java.math.RoundingMode;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;

import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.temporal.ChronoTemporal;

import org.apache.commons.math3.fraction.Fraction;

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

    @Override
    default boolean isSupported(final ChronoUnit unit) {
        switch (unit) {
            case HALF_DAYS:
            case DAYS:
            case WEEKS:
                return true;
            default:
                return false;
        }
    }

    @Override
    default Temporal plus(final long amountToAdd, final ChronoUnit unit) {
        switch (unit) {
            case HALF_DAYS:
                return this.plus(of(new Fraction(amountToAdd, 2)));
            case DAYS:
                return this.plus(of(amountToAdd));
            case WEEKS:
                return this.plus(of(Math.multiplyExact(amountToAdd, 7)));
            default:
                throw new UnsupportedTemporalTypeException(unit.name());
        }
    }

    @Override
    default boolean isSupported(final ChronoField field) {
        return field == ChronoField.MONTH_OF_YEAR;
    }

    @Override
    default long getLong(final ChronoField field) {
        if (field == ChronoField.MONTH_OF_YEAR) {
            return this.decimalValue().longValue();
        }
        throw new UnsupportedTemporalTypeException(field.name()); //TODO
    }

    static IntegerDays of(final int days) {
        return IntegerDays.of(days);
    }

    static Days of(final long days) {
        return IntegerDays.of(Math.toIntExact(days));
    }

    static Days of(final Fraction days) {
        throw new UnsupportedOperationException();
    }

}
