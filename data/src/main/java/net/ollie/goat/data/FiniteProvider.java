package net.ollie.goat.data;

import java.util.Map;

import javax.annotation.Nonnull;

/**
 *
 * @author ollie
 */
public interface FiniteProvider<K, V> extends Provider<K, V> {

    @Nonnull
    Map<K, V> getAll();

    @Override
    default V get(final K key) {
        return this.getAll().get(key);
    }

}
