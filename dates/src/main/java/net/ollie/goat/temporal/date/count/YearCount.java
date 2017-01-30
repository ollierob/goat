package net.ollie.goat.temporal.date.count;

import java.time.LocalDate;

import javax.annotation.Nonnull;

import net.ollie.goat.temporal.date.years.Years;

/**
 *
 * @author Ollie
 */
public interface YearCount {
    
    @Nonnull
    Years yearsBetween(@Nonnull LocalDate startInclusive, @Nonnull LocalDate endInclusive);

}
