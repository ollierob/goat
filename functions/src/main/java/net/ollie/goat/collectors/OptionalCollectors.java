package net.ollie.goat.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;

import net.ollie.goat.optionals.Optionals;

/**
 *
 * @author Ollie
 */
public final class OptionalCollectors {

    private OptionalCollectors() {
    }

    public static <T> Collector<Optional<T>, ?, Optional<T>> fromOptional() {
        return java.util.stream.Collector.<Optional<T>, List<Optional<T>>, Optional<T>>of(
                ArrayList::new,
                List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> Optionals.zeroOrOne(list).orElse(Optional.empty())
        );
    }

    public static <T> Collector<T, ?, Optional<T>> intoOptional() {
        return java.util.stream.Collector.<T, List<T>, Optional<T>>of(
                ArrayList::new,
                List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> Optionals.zeroOrOne(list));
    }

    public static <T> Collector<T, ?, Optional<T>> intoOptional(final Supplier<T> defaultValue) {
        return java.util.stream.Collector.<T, List<T>, Optional<T>>of(ArrayList::new, List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                list -> Optionals.zeroOrOne(list, defaultValue));
    }

}
