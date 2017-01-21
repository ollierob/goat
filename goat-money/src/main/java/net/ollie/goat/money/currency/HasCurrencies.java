package net.ollie.goat.money.currency;

import java.util.Set;

import javax.annotation.Nonnull;

/**
 *
 * @author Ollie
 */
public interface HasCurrencies {

    @Nonnull
    Set<? extends Currency> currencies();

}