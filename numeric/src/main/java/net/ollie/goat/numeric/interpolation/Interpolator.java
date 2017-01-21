package net.ollie.goat.numeric.interpolation;

import java.util.NavigableMap;

/**
 *
 * @author Ollie
 */
public interface Interpolator<K, V> {

    V interpolate(K key, NavigableMap<K, V> map);

}