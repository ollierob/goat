package net.ollie.goat.temporal.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.IsoChronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Objects;

/**
 *
 * @author Ollie
 */
public abstract class DateWrapper implements HasDate, ChronoLocalDate {

    private final LocalDate date;

    protected DateWrapper(final LocalDate date) {
        this.date = date;
    }

    @Override
    public LocalDate date() {
        return date;
    }

    @Override
    public IsoChronology getChronology() {
        return date.getChronology();
    }

    @Override
    public int lengthOfMonth() {
        return date.lengthOfMonth();
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return date.until(endExclusive, unit);
    }

    @Override
    public Period until(final ChronoLocalDate endDateExclusive) {
        return date.until(endDateExclusive);
    }

    @Override
    public long getLong(final TemporalField field) {
        return date.getLong(field);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DateWrapper other = (DateWrapper) obj;
        return this.is(other.date);
    }

}
