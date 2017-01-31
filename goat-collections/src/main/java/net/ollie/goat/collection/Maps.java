package net.ollie.goat.collection;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 *
 * @author Ollie
 */
public abstract class Maps {

    protected Maps() {
    }

    public static <K, V1, V2> Map<K, V2> lazilyTransformValues(final Map<K, V1> in, final Function<? super V1, ? extends V2> transform) {
        return new AbstractMap<K, V2>() {

            @Override
            public V2 get(final Object key) {
                final V1 value = in.get(key);
                return value == null ? null : transform.apply(value);
            }

            @Override
            public boolean containsKey(final Object key) {
                return in.containsKey(key);
            }

            @Override
            public Set<K> keySet() {
                return in.keySet();
            }

            @Override
            public Set<Map.Entry<K, V2>> entrySet() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int size() {
                return in.size();
            }

        };
    }

    public static <K, V1, V2> Map<K, V2> eagerlyTransformValues(final Map<K, V1> in, final Function<? super V1, ? extends V2> transform) {
        final Map<K, V2> out = new HashMap<>(in.size());
        in.forEach((k, v) -> out.put(k, transform.apply(v)));
        return out;
    }

}
