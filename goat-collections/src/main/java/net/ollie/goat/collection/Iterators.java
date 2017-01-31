package net.ollie.goat.collection;

import java.util.Iterator;
import java.util.function.Function;

/**
 *
 * @author ollie
 */
public class Iterators {

    public static <F, T> Iterator<T> transform(final Iterator<F> iterator, final Function<? super F, ? extends T> transformation) {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return transformation.apply(iterator.next());
            }

        };

    }

}
