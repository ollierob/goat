package net.ollie.goat.numeric.percentage;

import javax.annotation.Nonnull;

import net.ollie.goat.numeric.Numeric;

/**
 *
 * @author Ollie
 */
public abstract class Percentage extends Number implements Numeric.Summable<Percentage> {

    private static final long serialVersionUID = 1L;

    public abstract boolean isNegative();

    @Nonnull
    public abstract Percentage inverse();

}