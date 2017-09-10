package net.ollie.goat.data;

import javax.annotation.CheckForNull;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author ollie
 */
public interface BiProvider<K1, K2, V> extends Provider<KeyPair<K1, K2>, V> {

    @CheckForNull
    Element<V> getElement(K1 k1, K2 k2);

    @Override
    @Deprecated
    default Element<V> getElement(final KeyPair<K1, K2> pair) {
        return this.getElement(pair.left(), pair.right());
    }

    @Override
    default V get(final KeyPair<K1, K2> pair) {
        return Functions.ifNonNull(this.getElement(pair.left(), pair.right()), Element::value);
    }

}
