package net.ollie.goat.numeric.manifold;

import java.util.NavigableMap;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import net.ollie.goat.numeric.interpolation.Interpolator;

/**
 *
 * @author Ollie
 */
public interface Curve<X, Y> {

    @CheckForNull
    Y at(X x);

    @CheckForNull
    Y get(X x, Interpolator<X, Y> interpolator);

    @Nonnull
    NavigableMap<X, Y> toMap();

}