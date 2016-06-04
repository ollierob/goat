package net.ollie.goat.numeric;

import java.math.BigDecimal;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 * @author Ollie
 */
public abstract class BigDecimals {

    protected BigDecimals() {
    }

    @Nonnull
    public static BigDecimal toBigDecimal(final int i) {
        switch (i) {
            case 0:
                return BigDecimal.ZERO;
            case 1:
                return BigDecimal.ONE;
            case 10:
                return BigDecimal.TEN;
            default:
                return BigDecimal.valueOf(i);
        }
    }

    @Nonnull
    public static BigDecimal toBigDecimal(@Nonnull final Number number) {
        if (number instanceof Integer) {
            return toBigDecimal((int) number);
        }
        return number instanceof BigDecimal
                ? (BigDecimal) number
                : new BigDecimal(number.toString());
    }

    @Nonnull
    public static boolean isOne(@Nonnull final BigDecimal number) {
        return number == BigDecimal.ONE || number.compareTo(BigDecimal.ONE) == 0;
    }

    public static boolean valuesEqual(@Nullable final BigDecimal b1, @Nullable final BigDecimal b2) {
        return b1 == b2
                || (b1 != null && b2 != null && b1.compareTo(b2) == 0);
    }

}
