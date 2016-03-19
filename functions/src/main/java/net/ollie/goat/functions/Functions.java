package net.ollie.goat.functions;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import net.ollie.goat.suppliers.CheckedSupplier;

/**
 *
 * @author Ollie
 */
public final class Functions {

    private Functions() {
    }

    public static <T, R> R ifNonNull(final T object, final Function<? super T, ? extends R> transform) {
        return object == null ? null : transform.apply(object);
    }

    public static <T> boolean ifBothNonNull(final T left, final T right, final BiPredicate<T, T> ifBothNonNull) {
        return left == null
                ? right == null
                : right != null && ifBothNonNull.test(left, right);
    }

    public static <T> T ifBothNonNull(final T left, final T right, final BinaryOperator<T> ifBothNonNull) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return ifBothNonNull.apply(left, right);
        }
    }

    public static <T, X extends Exception> T ifNull(final T object, final CheckedSupplier<? extends T, X> supplier) throws X {
        return object == null ? supplier.get() : object;
    }

}
