package net.ollie.goat.time;

import net.ollie.goat.date.HasDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.annotation.Nonnull;

/**
 *
 * @author Ollie
 */
public interface HasTime extends HasDate {

    @Nonnull
    Instant time();

    @Nonnull
    default ZonedDateTime dateTime() {
        return this.dateTime(ZoneId.systemDefault());
    }

    @Nonnull
    default ZonedDateTime dateTime(final ZoneId zone) {
        return ZonedDateTime.ofInstant(this.time(), zone);
    }

    @Override
    default LocalDate date() {
        return this.dateTime().toLocalDate();
    }

    static int compareByTime(final HasTime left, final HasTime right) {
        return left.time().compareTo(right.time());
    }

}
