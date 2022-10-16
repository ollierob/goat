package net.ollie.goat.temporal.date.interim;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.SortedSet;
import java.util.Spliterator;

/**
 * 
 * @author ollie
 */
public abstract class Interval
        extends AbstractList<LocalDate>
        implements Interim, SortedSet<LocalDate> {

    private static final long serialVersionUID = 1L;

    private final LocalDate startInclusive;
    private final LocalDate endInclusive;

    protected Interval(LocalDate startInclusive, LocalDate endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    @Nonnull
    public LocalDate startInclusive() {
        return startInclusive;
    }

    @Nonnull
    public LocalDate endInclusive() {
        return endInclusive;
    }

    @Nonnull
    public LocalDate endExclusive() {
        return endInclusive.plusDays(1);
    }

    @Override
    public Spliterator<LocalDate> spliterator() {
        return super.spliterator();
    }

}
