package net.ollie.goat.date;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nonnull;

/**
 *
 * @author ollie
 */
public interface Interim extends Collection<LocalDate> {

    boolean contains(LocalDate date);

    @Nonnull
    Optional<Interval> closed();

}
