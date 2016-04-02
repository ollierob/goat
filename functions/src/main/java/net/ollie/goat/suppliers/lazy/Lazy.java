package net.ollie.goat.suppliers.lazy;

import java.util.function.Supplier;

import net.ollie.goat.suppliers.NonNullSupplier;

/**
 *
 * @author Ollie
 */
public interface Lazy<T> extends Supplier<T> {

    static <T> Lazy<T> loadOnce(final Supplier<? extends T> supplier) {
        return new LoadOnceVolatileLazy<>(supplier);
    }

    static <T> Lazy<T> loadOnceNonnull(final NonNullSupplier<? extends T> supplier) {
        return new LoadOneNonnullLazy<>(supplier);
    }

}
