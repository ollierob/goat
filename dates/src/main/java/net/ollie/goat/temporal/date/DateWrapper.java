package net.ollie.goat.temporal.date;

import java.time.LocalDate;

import net.ollie.goat.temporal.date.HasDate;

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

}
