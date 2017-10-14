package net.ollie.goat.data;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author Ollie
 */
public interface CompositeProvider<K1, K2, V, P extends Provider<K2, V>> extends Provider<K1, P> {

    @CheckForNull
    default V get(final K1 k1, final K2 k2) {
        return Functions.ifNonNull(this.get(k1), provider -> provider.get(k2));
    }

    @Nonnull
    default V require(final K1 k1, final K2 k2) {
        return this.require(k1).require(k2);
    }

}
