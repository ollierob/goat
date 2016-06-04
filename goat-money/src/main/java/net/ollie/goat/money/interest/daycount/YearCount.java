package net.ollie.goat.money.interest.daycount;

import java.time.LocalDate;

import javax.annotation.Nonnull;

import net.ollie.goat.date.years.Years;

/**
 *
 * @author Ollie
 */
public interface YearCount {

    @Nonnull
    Years yearsBetween(@Nonnull LocalDate startInclusive, @Nonnull LocalDate endInclusive);

}
