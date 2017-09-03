package net.ollie.goat.collectors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;

import javax.annotation.Nonnull;

import net.ollie.goat.exceptions.Exceptions;

/**
 *
 * @author Ollie
 */
public final class OptionalCollectors {

    private OptionalCollectors() {
    }

    public static <T> Collector<T, ?, Optional<T>> zeroOrOne() {
        return java.util.stream.Collector.<T, List<T>, Optional<T>>of(
                ArrayList::new,
                List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> zeroOrOne(list));
    }

    public static <T> Collector<T, ?, Optional<T>> zeroOrOne(final Supplier<T> defaultValue) {
        return java.util.stream.Collector.<T, List<T>, Optional<T>>of(ArrayList::new, List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> zeroOrOne(list, defaultValue));
    }

    public static <T> Optional<T> zeroOrOne(final Iterable<T> iterable) {
        return zeroOrOne(iterable, () -> null);
    }

    public static <T> Optional<T> zeroOrOne(final Iterable<T> iterable, @Nonnull final Supplier<T> defaultValue) {
        final Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return Optional.ofNullable(defaultValue.get());
        }
        iterator.next();
        return iterator.hasNext()
                ? Exceptions.throwIllegalArgumentException("More than one element inside [" + iterable + "]!")
                : Optional.empty();
    }

}
