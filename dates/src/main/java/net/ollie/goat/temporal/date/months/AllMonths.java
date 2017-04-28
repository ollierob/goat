package net.ollie.goat.temporal.date.months;

import java.time.Month;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.collection.Iterators;

/**
 *
 * @author ollie
 */
@XmlRootElement
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
