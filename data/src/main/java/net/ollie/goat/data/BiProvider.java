package net.ollie.goat.data;

import javax.annotation.CheckForNull;

/**
 *
 * @author ollie
 */
public interface BiProvider<K1, K2, V> extends Provider<KeyPair<K1, K2>, V> {

    @CheckForNull
    V get(K1 k1, K2 k2);

    @Override
    @Deprecated
    default V get(final KeyPair<K1, K2> pair) {
        return this.get(pair.left(), pair.right());
    }

}
