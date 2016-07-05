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

    public static Percentage oneBasisPoint() {
        return DecimalPercentage.basisPoints(1);
    }

    public static Percentage zero() {
        return DecimalPercentage.ZERO_PERCENT;
    }

}
