package net.ollie.goat.money.interest.accrual;

import net.ollie.goat.money.Money;
import net.ollie.goat.money.currency.Currency;
import net.ollie.goat.numeric.percentage.Percentage;
import net.ollie.goat.temporal.date.years.Years;

/**
 *
 * @author Ollie
 */
public interface InterestAccrual {

    <C extends Currency> Money<C> accrue(Money<C> money, Percentage annualRate, Years term);

    static InterestAccrual simple() {
        return SimpleInterestAccrual.INSTANCE;
    }

    static InterestAccrual compound(final double yearlyFrequency) {
        return new CompoundInterestAccrual(yearlyFrequency);
    }

    static InterestAccrual continuous() {
        return ContinuousInterestAccrual.INSTANCE;
    }

}
