package net.ollie.goat.suppliers.lazy;

import java.util.function.Supplier;

/**
 *
 * @author Ollie
 */
public interface Lazy<T> extends Supplier<T> {

    static <T> Lazy<T> loadOnce(final Supplier<? extends T> supplier) {
        return new LoadOnceVolatileLazy<>(supplier);
    }

}
