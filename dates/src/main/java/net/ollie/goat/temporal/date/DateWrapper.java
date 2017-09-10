package net.ollie.goat.temporal.date;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Ollie
 */
public abstract class DateWrapper implements HasDate {

    private final LocalDate date;

    protected DateWrapper(final LocalDate date) {
        this.date = date;
    }

    @Override
    public LocalDate date() {
        return date;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DateWrapper other = (DateWrapper) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

}
