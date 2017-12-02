package net.ollie.goat.temporal;

import com.sun.istack.internal.NotNull;
import net.ollie.goat.temporal.date.HasDate;

import javax.annotation.Nonnull;
import java.time.*;
import java.util.Optional;

public interface PartialDateTime extends HasDate {

    @Override
    @Nonnull
    LocalDate date();

    @NotNull
    Optional<LocalTime> time();

    @Nonnull
    default ZoneId zoneId() {
        return ZoneOffset.UTC;
    }

    @Nonnull
    default Optional<ZonedDateTime> toDateTime() {
        return this.time().map(time -> ZonedDateTime.of(this.date(), time, this.zoneId()));
    }

}
