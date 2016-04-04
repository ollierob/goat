package net.ollie.goat.date;

import java.time.LocalDate;
import java.time.Period;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author Ollie
 */
public class Dates {

    public static double DAYS_PER_YEAR = 365.2425d;

    protected Dates() {
    }

    public static boolean equals(final LocalDate left, final LocalDate right) {
        return Functions.ifBothNonNull(left, right, (final LocalDate l, final LocalDate r) -> l.compareTo(r) == 0);
    }

    public static double approximateLength(final Period period) {
        return period.getYears()
                + (period.getMonths() / 12.d)
                + (period.getDays() / DAYS_PER_YEAR);
    }

    public static boolean areOrdered(final LocalDate d1, final LocalDate d2) {
        return !d1.isAfter(d2);
    }

    public static boolean areOrdered(final LocalDate d1, final LocalDate d2, final LocalDate d3) {
        return areOrdered(d1, d2) && areOrdered(d2, d3);
    }

}
