package net.ollie.goat.temporal.date.months;

import net.ollie.goat.collection.Sets;

import java.time.Month;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author ollie
 */
public class SomeMonths implements Months {

    private final Set<Month> months;

    public SomeMonths(final Month... months) {
        this.months = Sets.asSet(months);
    }

    public SomeMonths(final Collection<Month> months) {
        this.months = new HashSet<>(months);
    }

    @Override
    public boolean contains(final Month month) {
        return months.contains(month);
    }

    @Override
    public Iterator<Month> iterator() {
        return months.iterator();
    }

}
