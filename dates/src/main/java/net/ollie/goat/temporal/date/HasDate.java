package net.ollie.goat.temporal.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

import javax.annotation.Nonnull;

/**
 *
 * @author Ollie
 */
public interface HasDate {

    @Nonnull
    LocalDate date();

    @Nonnull
    default Year year() {
        return Year.of(this.date().getYear());
    }

    @Nonnull
    default Month month() {
        return this.date().getMonth();
    }

    @Nonnull
    default YearMonth yearMonth() {
        final LocalDate date = this.date();
        return YearMonth.of(date.getYear(), date.getMonth());
    }

    @Nonnull
    default MonthDay monthDay() {
        final LocalDate date = this.date();
        return MonthDay.of(date.getMonth(), date.getDayOfMonth());
    }

    default boolean isOnWeekday() {
        return !this.isOnWeekend();
    }

    default boolean isOnWeekend() {
        switch (this.date().getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
        }
    }

    static int compareByDate(final HasDate left, final HasDate right) {
        return left.date().compareTo(right.date());
    }

}
