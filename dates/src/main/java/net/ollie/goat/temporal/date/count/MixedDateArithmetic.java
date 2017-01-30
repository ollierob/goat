package net.ollie.goat.temporal.date.count;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import net.ollie.goat.temporal.date.years.Years;

/**
 *
 * @author ollie
 */
@XmlRootElement
public class MixedDateArithmetic implements DateArithmetic {

    @XmlElementRef(name = "day_count")
    private DayCount dayCount;

    @XmlElementRef(name = "year_count")
    private YearCount yearCount;

    @Deprecated
    MixedDateArithmetic() {
    }

    public MixedDateArithmetic(final DayCount dayCount, final YearCount yearCount) {
        this.dayCount = dayCount;
        this.yearCount = yearCount;
    }

    @Override
    public int daysBetween(LocalDate startInclusive, LocalDate endExclusive) {
        return dayCount.daysBetween(startInclusive, endExclusive);
    }

    @Override
    public Years yearsBetween(LocalDate startInclusive, LocalDate endExclusive) {
        return yearCount.yearsBetween(startInclusive, endExclusive);
    }

}