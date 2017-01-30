package net.ollie.goat.temporal;

import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import javax.annotation.Nonnull;

/**
 * Bridge between {@link TemporalUnit} and {@link ChronoUnit}.
 *
 * @author Ollie
 */
public interface ChronoTemporal extends Temporal {

    @Nonnull
    Period toPeriod();

    default ChronoUnit toChronoUnit(final TemporalUnit unit) {
        if (unit instanceof ChronoUnit) {
            return (ChronoUnit) unit;
        }
        throw new UnsupportedTemporalTypeException("Unit is not a chrono unit: " + unit);
    }

    @Override
    @Deprecated
    default boolean isSupported(final TemporalUnit unit) {
        return this.isSupported(this.toChronoUnit(unit));
    }

    boolean isSupported(ChronoUnit unit);

    @Override
    @Deprecated
    default Temporal plus(final long amountToAdd, final TemporalUnit unit) {
        return this.plus(amountToAdd, this.toChronoUnit(unit));
    }

    Temporal plus(long amountToAdd, ChronoUnit unit);

    @Override
    @Deprecated
    default long until(final Temporal endExclusive, final TemporalUnit unit) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    @Deprecated
    default boolean isSupported(final TemporalField field) {
        return field instanceof ChronoField
                && this.isSupported((ChronoField) field);
    }

    boolean isSupported(ChronoField field);

    @Override
    @Deprecated
    default long getLong(final TemporalField field) {
        if (field instanceof ChronoField) {
            return this.getLong((ChronoField) field);
        }
        throw new UnsupportedTemporalTypeException("Field is not a chrono field: " + field);
    }

    long getLong(ChronoField field);

    @Override
    @Deprecated
    default Temporal with(final TemporalField field, final long newValue) {
        throw new UnsupportedOperationException(); //TODO
    }

}
