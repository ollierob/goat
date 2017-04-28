package net.ollie.goat.temporal.date.interim;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

import javax.annotation.Nonnull;

/**
 *
 * @author ollie
 */
public interface Interim {

    boolean contains(LocalDate date);

    @Nonnull
    Optional<CompleteInterval> closed();

    static CompleteInterval allOf(final YearMonth yearMonth) {
        return new CompleteInterval(yearMonth.atDay(1), yearMonth.atEndOfMonth());
    }

}
