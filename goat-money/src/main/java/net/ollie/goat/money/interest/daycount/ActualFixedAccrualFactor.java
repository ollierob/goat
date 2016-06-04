package net.ollie.goat.money.interest.daycount;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import net.ollie.goat.date.years.FractionalYears;
import net.ollie.goat.date.years.Years;

/**
 *
 * @author Ollie
 */
@XmlEnum
public enum ActualFixedAccrualFactor implements AccrualFactor, ActualDayCount {

    @XmlEnumValue("ACT_360")
    ACT_360(360),
    @XmlEnumValue("ACT_364")
    ACT_364(364),
    @XmlEnumValue("ACT_365")
    ACT_365(365);

    private final int daysPerYear;

    private ActualFixedAccrualFactor(int daysPerYear) {
        this.daysPerYear = daysPerYear;
    }

    @Override
    public Years yearsBetween(final LocalDate startInclusive, final LocalDate endExclusive) {
        return FractionalYears.of(this.daysBetween(startInclusive, endExclusive), daysPerYear);
    }

}
