package net.ollie.goat.optionals;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiPredicate;

/**
 *
 * @author Ollie
 */
public final class Optionals {

    private Optionals() {
    }

    public static boolean equalIfPresent(final Optional<?> left, final Optional<?> right) {
        return Optionals.equalIfPresent(left, right, Objects::equals);
    }

    public static <T> boolean equalIfPresent(final Optional<? extends T> left, final Optional<? extends T> right, final BiPredicate<? super T, ? super T> predicate) {
        return left.isPresent() && right.isPresent()
                ? predicate.test(left.get(), right.get())
                : false;
    }

    public static boolean equalIfAbsent(final Optional<?> left, final Optional<?> right) {
        return equalIfAbsent(left, right, Objects::equals);
    }

    public static <T> boolean equalIfAbsent(final Optional<? extends T> left, final Optional<? extends T> right, final BiPredicate<? super T, ? super T> predicate) {
        return left.isPresent() && right.isPresent()
                ? predicate.test(left.get(), right.get())
                : true;
    }

}
