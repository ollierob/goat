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

}
