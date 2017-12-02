package net.ollie.goat.temporal;

import net.ollie.goat.temporal.date.HasDate;

import javax.annotation.Nonnull;
import java.time.*;
import java.util.Optional;

public interface PartialDateTime extends HasDate {

    @Override
    @Nonnull
    LocalDate date();

    @Nonnull
    Optional<LocalTime> time();

    @Nonnull
    default ZoneId zoneId() {
        return ZoneOffset.UTC;
    }

    @Nonnull
    default Optional<ZonedDateTime> toDateTime() {
        return this.time().map(time -> ZonedDateTime.of(this.date(), time, this.zoneId()));
    }

    default ZonedDateTime toDateTimeOr(final LocalTime time) {
        return this.toDateTime().orElseGet(() -> ZonedDateTime.of(this.date(), time, this.zoneId()));
    }

    default ZonedDateTime toDateTimeOrMidnight() {
        return this.toDateTimeOr(LocalTime.MIDNIGHT);
    }

    default ZonedDateTime toDateTimeOrNoon() {
        return this.toDateTimeOr(LocalTime.NOON);
    }

}
