package net.ollie.goat.temporal.date.interim;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;

/**
 *
 * @author ollie
 */
public class MonthYearInterval implements Interim {

    private final YearMonth yearMonth;

    public MonthYearInterval(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    @Override
    public boolean contains(final LocalDate date) {
        return yearMonth.getYear() == date.getYear()
                && yearMonth.getMonthValue() == date.getMonthValue();
    }

    @Override
    public Optional<CompleteInterval> closed() {
        return Optional.of(new CompleteInterval(yearMonth.atDay(1), yearMonth.atEndOfMonth()));
    }

}
