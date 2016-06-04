package net.ollie.goat.money.interest.accrual;

import net.ollie.goat.money.Money;
import net.ollie.goat.money.currency.Currency;
import net.ollie.goat.numeric.percentage.Percentage;
import net.ollie.goat.temporal.date.years.Years;

/**
 *
 * @author Ollie
 */
public class ContinuousInterestAccrual implements InterestAccrual {

    static final InterestAccrual INSTANCE = new ContinuousInterestAccrual();

    ContinuousInterestAccrual() {
    }

    @Override
    public <C extends Currency> Money<C> accrue(final Money<C> money, final Percentage annualRate, final Years term) {
        final double multiplier = Math.exp(annualRate.doubleValue() * term.doubleValue());
        return money.times(multiplier);
    }

}
