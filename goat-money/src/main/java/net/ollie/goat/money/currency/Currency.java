package net.ollie.goat.money.currency;

import javax.annotation.Nonnull;

/**
 * A monetary unit.
 *
 * @author Ollie
 */
public interface Currency extends HasCurrency {

    /**
     * @return the character(s) that are used, for example {@code $} for US dollars.
     */
    @Nonnull
    String symbol();

    /**
     * @return a string uniquely representing this currency.
     */
    @Nonnull
    String uniqueSymbol();

    @Override
    @Deprecated
    default Currency currency() {
        return this;
    }

}
