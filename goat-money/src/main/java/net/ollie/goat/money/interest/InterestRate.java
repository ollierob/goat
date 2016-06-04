package net.ollie.goat.money.interest;

import java.time.LocalDate;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

import net.ollie.goat.money.Money;
import net.ollie.goat.money.currency.Currency;
import net.ollie.goat.numeric.percentage.Percentage;
import net.ollie.goat.temporal.date.count.AccrualFactor;

/**
 *
 * @author Ollie
 */
public interface InterestRate {

    @Nonnull
    AccrualFactor accrual();

    @Nonnull
    Percentage spot(LocalDate fixing);

    @Nonnull
    Percentage forward(LocalDate fixing, LocalDate out);

    @Nonnull
    <C extends Currency> Money<C> accrue(Money<C> money, LocalDate from, LocalDate until);

    @Nonnull
    default <C extends Currency> Money<C> accrued(final Money<C> money, final LocalDate earlier, final LocalDate later) {
        return this.accrue(money, earlier, later).minus(money);
    }

    @Nonnull
    default <C extends Currency> Money<C> discount(final Money<C> money, final LocalDate earlier, final LocalDate later) {
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
