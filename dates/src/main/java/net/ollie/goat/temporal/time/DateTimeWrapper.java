package net.ollie.goat.temporal.time;

import net.ollie.goat.temporal.PartialDateTime;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

public abstract class DateTimeWrapper implements PartialDateTime {

    private final ZonedDateTime zonedDateTime;

    protected DateTimeWrapper(final ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @Nonnull
    @Override
    public LocalDate date() {
        return zonedDateTime.toLocalDate();
    }

    @Nonnull
    @Override
    public ZoneId zoneId() {
        return zonedDateTime.getZone();
    }

    @Override
    public Optional<LocalTime> time() {
        return Optional.of(zonedDateTime.toLocalTime());
    }

    @Nonnull
    @Override
    @Deprecated
    public Optional<ZonedDateTime> toDateTime() {
        return Optional.of(zonedDateTime);
    }

    @Nonnull
    public ZonedDateTime zonedDateTime() {
        return zonedDateTime;
    }

    @Override
    public String toString() {
        return zonedDateTime.toString();
    }
}
