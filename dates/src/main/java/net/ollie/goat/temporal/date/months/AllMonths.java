package net.ollie.goat.temporal.date.months;

import net.ollie.goat.collection.Iterators;

import java.time.Month;
import java.util.Iterator;

/**
 *
 * @author ollie
 */
public class AllMonths implements Months {

    @Override
    public boolean contains(final Month month) {
        return true;
    }

    @Override
    public Iterator<Month> iterator() {
        return Iterators.of(Month.values());
    }

}
