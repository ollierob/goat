package net.ollie.goat.collection;

import java.util.function.Predicate;

/**
 *
 * @author Ollie
 */
public abstract class Collections {

    protected Collections() {
    }

    public static <T> boolean any(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        for (final T element : iterable) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

}
