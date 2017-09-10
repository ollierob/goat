package net.ollie.goat.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author Ollie
 */
public interface Provider<K, V> {

    @CheckForNull
    Element<V> getElement(K key);

    @CheckForNull
    default V get(K key) {
        return Functions.ifNonNull(this.getElement(key), Element::value);
    }

    @Nonnull
    default Optional<V> maybeGet(final K key) {
        return Optional.ofNullable(this.get(key));
    }

    @Nonnull
    default V require(final K key) {
        return Objects.requireNonNull(this.get(key), () -> "Missing [" + key + "]!");
    }

    @Nonnull
    default <X extends Exception> V require(final K key, final Function<? super K, ? extends X> ifAbsent) throws X {
        final V value = this.get(key);
        if (value == null) {
            throw ifAbsent.apply(key);
        }
        return value;
    }

    @Nonnull
    default Map<K, V> getAll(final Set<K> keys) {
        final Map<K, V> all = new HashMap<>(keys.size());
        for (final K key : keys) {
            final V value = this.get(key);
            if (value != null) {
                all.put(key, value);
            }
        }
        return all;
    }

}
