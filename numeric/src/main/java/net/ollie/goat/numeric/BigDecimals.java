package net.ollie.goat.numeric;

import java.math.BigDecimal;

/**
 *
 * @author Ollie
 */
public abstract class BigDecimals {

    protected BigDecimals() {
    }

    public static BigDecimal toBigDecimal(final Number number) {
        if (Numbers.isNativeIntegral(number)) {
            switch (number.intValue()) {
                case 0:
                    return BigDecimal.ZERO;
                case 1:
                    return BigDecimal.ONE;
                case 10:
                    return BigDecimal.TEN;
                default:
                    return BigDecimal.valueOf(number.longValue());
            }
        }
        return number instanceof BigDecimal
                ? (BigDecimal) number
                : new BigDecimal(number.toString());
    }

    public static boolean isOne(final BigDecimal number) {
        return number == BigDecimal.ONE || number.compareTo(BigDecimal.ONE) == 0;
    }

}
