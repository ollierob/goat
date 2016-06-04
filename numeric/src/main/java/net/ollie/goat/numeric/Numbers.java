package net.ollie.goat.numeric;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.ollie.goat.functions.Functions;

/**
 * Extension methods for numbers.
 *
 * @author Ollie
 */
public abstract class Numbers {

    public static final BigDecimal ONE_HUNDRED = BigDecimal.ONE.movePointRight(2);

    protected Numbers() {
    }

    public static boolean isNativeIntegral(final Number number) {
        return number instanceof Integer || number instanceof Long;
    }

    public static boolean isOne(final Number number) {
        if (isNativeIntegral(number)) {
            return number.intValue() == 1;
        }
        return BigDecimals.isOne(BigDecimals.toBigDecimal(number));
    }

    public static boolean equals(final Number left, final Number right) {
        return left == null
                ? right == null
                : right != null && left.doubleValue() == right.doubleValue(); //FIXME
    }

    public static Integer add(final Integer left, final Integer right) {
        return Functions.ifBothNonNull(left, right, (final Integer i, final Integer j) -> i + j);
    }

    public static int round(final double d, final RoundingMode rounding) {
        switch (rounding) {
            case UP:
                return (int) (d > 0 ? Math.ceil(d) : Math.floor(d));
            case DOWN:
                return (int) d;
            case CEILING:
                return (int) Math.ceil(d);
            case FLOOR:
                return (int) Math.floor(d);
            default:
                throw new UnsupportedOperationException(); //TODO
        }
    }

    @SuppressWarnings("unchecked")
    public static int compare(final Number n1, final Number n2) {
        if (n1 instanceof Comparable && n1.getClass().isAssignableFrom(n2.getClass())) {
            return ((Comparable) n1).compareTo(n2);
        }
        return BigDecimals.toBigDecimal(n1).compareTo(BigDecimals.toBigDecimal(n2));
    }

}
