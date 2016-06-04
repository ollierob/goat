package net.ollie.goat.money.fx;

import javax.annotation.Nonnull;

import net.ollie.goat.currency.CurrencyId;
import net.ollie.goat.numeric.fraction.DecimalFraction;
import net.ollie.goat.money.FractionalMoney;
import net.ollie.goat.money.Money;

/**
 *
 * @author Ollie
 */
public interface ExchangeRate<F extends CurrencyId, T extends CurrencyId> extends Comparable<ExchangeRate<F, T>> {

    @Nonnull
    F from();

    @Nonnull
    T to();

    @Nonnull
    DecimalFraction rate();

    default Money<T> convert(final Money<F> from) {
        return new FractionalMoney<>(this.to(), this.rate().times(from.amount()));
    }

    default Money<F> convertFrom(final Money<T> from) {
        return new FractionalMoney<>(this.from(), this.rate().over(from.amount()));
    }

    default ExchangeRate<T, F> inverse() {
        return new InverseExchangeRate<>(this);
    }

    @Override
    default int compareTo(final ExchangeRate<F, T> that) {
        return this.rate().compareTo(that.rate());
    }

}
