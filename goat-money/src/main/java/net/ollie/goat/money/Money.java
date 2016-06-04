package net.ollie.goat.money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.annotation.Nonnull;

import net.ollie.goat.currency.CurrencyId;
import net.ollie.goat.currency.HasCurrencyId;
import net.ollie.goat.numeric.Numbers;
import net.ollie.goat.numeric.Numeric;
import net.ollie.goat.numeric.fraction.DecimalFraction;

/**
 *
 * @author Ollie
 */
public interface Money<C extends CurrencyId>
        extends HasCurrencyId, Numeric.Summable<Money<C>>, Serializable {

    @Override
    C currencyId();

    @Nonnull
    Number amount();

    @Override
    Money<C> times(Number n);

    @Override
    Money<C> plus(@Nonnull Money<C> that);

    @Override
    default Money<C> minus(final Money<C> that) {
        return this.plus(that.negate());
    }

    @Nonnull
    default DecimalMoney<C> toDecimal() {
        return DecimalMoney.valueOf(this.currencyId(), this.amount());
    }

    @Nonnull
    default Money<C> over(final Number number) {
        return new FractionalMoney<>(this.currencyId(), DecimalFraction.of(this.amount(), number));
    }

    default String toString(@Nonnull final MoneyFormat convention) {
        return convention.toString(this);
    }

    static <C extends CurrencyId> DecimalMoney<C> zero(final C currency) {
        return new DecimalMoney<>(currency, BigDecimal.ZERO);
    }

    static boolean valuesEqual(final Money<?> left, final Money<?> right) {
        return Objects.equals(left.currencyId(), right.currencyId())
                && Numbers.equals(left.amount(), right.amount());
    }

    static int hashCode(final Money<?> money) {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(money.currencyId());
        hash = 29 * hash + Double.hashCode(money.doubleValue());
        return hash;
    }

}
