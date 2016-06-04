package net.ollie.goat.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ollie
 */
public class Sets {

    @SafeVarargs
    public static <T> Set<T> asUnmodifiableSet(final T... array) {
        return java.util.Collections.unmodifiableSet(asSet(array));
    }

    @SafeVarargs
    public static <T> Set<T> asSet(final T... array) {
        return new HashSet<>(Arrays.asList(array));
    }

    public static <T> Set<T> eagerUnion(final Set<? extends T> s1, final Set<? extends T> s2) {
        final Set<T> set = new HashSet<>(s1.size() + s2.size());
        set.addAll(s1);
        set.addAll(s2);
        return set;
    }

}
