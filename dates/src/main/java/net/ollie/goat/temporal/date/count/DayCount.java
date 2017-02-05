package net.ollie.goat.temporal.date.count;

import java.time.LocalDate;
import java.util.OptionalInt;

import javax.annotation.Nonnull;

import net.ollie.goat.temporal.date.interim.CompleteInterval;
import net.ollie.goat.temporal.date.interim.Interim;

/**
 *
 * @author Ollie
 */
public interface DayCount {

    int daysBetween(@Nonnull LocalDate startInclusive, @Nonnull LocalDate endExclusive);

    default int daysIn(@Nonnull final CompleteInterval interim) {
        return this.daysBetween(interim.startInclusive(), interim.endExclusive());
    }

    @Nonnull
    default OptionalInt daysIn(@Nonnull final Interim interim) {
        return interim.closed().map(this::daysIn).map(OptionalInt::of).orElse(OptionalInt.empty());
    }
    
    ActualDayCount ACTUAL = ActualActualDateArithmetic.ACT_ACT;

}
