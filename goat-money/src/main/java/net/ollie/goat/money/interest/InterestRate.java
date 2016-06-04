package net.ollie.goat.money.interest;

import java.time.LocalDate;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

import net.ollie.goat.currency.CurrencyId;
import net.ollie.goat.money.Money;
import net.ollie.goat.money.interest.daycount.AccrualFactor;
import net.ollie.goat.numeric.percentage.Percentage;

/**
 *
 * @author Ollie
 */
public interface InterestRate {

    @Nonnull
    AccrualFactor accrual();

    @Nonnull
    Percentage fixing(LocalDate date);

    @Nonnull
    <C extends CurrencyId> Money<C> accrue(Money<C> money, LocalDate start, LocalDate accrualDate);

    @Nonnull
    default <C extends CurrencyId> Money<C> accrued(final Money<C> money, final LocalDate earlier, final LocalDate later) {
        return this.accrue(money, earlier, later).minus(money);
    }

    @Nonnull
    default <C extends CurrencyId> Money<C> discount(final Money<C> money, final LocalDate earlier, final LocalDate later) {
        return this.accrue(money, later, earlier);
    }

    @Nonnull
    @CheckReturnValue
    InterestRate plus(Percentage bump);

    @Nonnull
    @CheckReturnValue
    default InterestRate minus(final Percentage bump) {
        return this.plus(bump.negate());
    }

}
