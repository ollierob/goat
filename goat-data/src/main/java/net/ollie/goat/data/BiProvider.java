package net.ollie.goat.data;

import javax.annotation.CheckForNull;

import net.ollie.goat.data.BiProvider.Pair;

/**
 *
 * @author ollie
 */
public interface BiProvider<K1, K2, V>
        extends Provider<Pair<K1, K2>, V> {

    @CheckForNull
    V get(K1 k1, K2 k2);

    @Override
    @Deprecated
    default V get(final Pair<K1, K2> pair) {
        return this.get(pair.left(), pair.right());
    }

    class Pair<L, R> {

        private final L left;
        private final R right;

        public Pair(L a, R b) {
            this.left = a;
            this.right = b;
        }

        public L left() {
            return left;
        }

        public R right() {
            return right;
        }

    }

}
