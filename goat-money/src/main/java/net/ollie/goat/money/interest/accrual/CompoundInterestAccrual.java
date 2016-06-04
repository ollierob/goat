package net.ollie.goat.money.interest.accrual;

import net.ollie.goat.money.Money;
import net.ollie.goat.money.currency.Currency;
import net.ollie.goat.numeric.percentage.Percentage;
import net.ollie.goat.temporal.date.years.Years;

/**
 *
 * @author Ollie
 */
public class CompoundInterestAccrual implements InterestAccrual {

    private final double yearlyFrequency;

    public CompoundInterestAccrual(final double yearlyFrequency) {
        this.yearlyFrequency = yearlyFrequency;
    }

    @Override
    public <C extends Currency> Money<C> accrue(Money<C> money, Percentage annualRate, Years term) {
        final double multiplier = Math.pow(1. + annualRate.doubleValue() / yearlyFrequency, yearlyFrequency * term.doubleValue());
        return money.times(multiplier);
    }

}
