package net.ollie.goat.numeric.percentage;

import net.ollie.goat.numeric.Numeric;

/**
 *
 * @author Ollie
 */
public abstract class Percentage extends Number implements Numeric.Summable<Percentage> {

    private static final long serialVersionUID = 1L;

    public abstract boolean isNegative();

    @Override
    public Percentage plus(final Percentage that) {
        return new DecimalPercentage(this.decimalValue().add(that.decimalValue()));
    }

    public static Percentage oneBasisPoint() {
        return DecimalPercentage.basisPoints(1);
    }

    public static Percentage zero() {
        return DecimalPercentage.ZERO_PERCENT;
    }

    public static Percentage oneHundred() {
        return DecimalPercentage.ONE_HUNDRED_PERCENT;
    }

    public static Percentage of(final long percentage) {
        return new IntegerPercentage(percentage);
    }

}
