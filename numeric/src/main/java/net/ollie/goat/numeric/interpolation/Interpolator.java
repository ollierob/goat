package net.ollie.goat.numeric.interpolation;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.NavigableMap;

import javax.annotation.CheckForNull;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author Ollie
 */
public interface Interpolator<K, V> {

    @CheckForNull
    V interpolate(K key, NavigableMap<K, V> map);

    @CheckForNull
    default Entry<K, V> interpolateEntry(final K key, final NavigableMap<K, V> map) {
        return Functions.ifNonNull(this.interpolate(key, map), value -> new SimpleImmutableEntry<>(key, value));
    }
    
}
