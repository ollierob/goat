package net.ollie.goat.date.years;

import java.time.LocalDate;

import javax.annotation.Nonnull;

import net.ollie.goat.numeric.Numeric;

/**
 *
 * @author ollie
 */
public interface Years extends Comparable<Years>, Numeric.Summable<Years> {

    @Nonnull
    LocalDate addTo(LocalDate date);

}
