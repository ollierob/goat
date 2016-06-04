package net.ollie.goat.temporal.date.count;

import java.time.LocalDate;
import java.util.OptionalInt;

import javax.annotation.Nonnull;

import net.ollie.goat.temporal.date.Interim;
import net.ollie.goat.temporal.date.Interval;

/**
 *
 * @author Ollie
 */
public interface DayCount {

    int daysBetween(@Nonnull LocalDate startInclusive, @Nonnull LocalDate endExclusive);

    default int daysIn(@Nonnull final Interval interim) {
        return this.daysBetween(interim.startInclusive(), interim.endExclusive());
    }

    @Nonnull
    default OptionalInt daysIn(@Nonnull final Interim interim) {
        return interim.closed().map(this::daysIn).map(OptionalInt::of).orElse(OptionalInt.empty());
    }

}
