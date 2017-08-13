package net.ollie.goat.numeric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 * @author Ollie
 */
public abstract class BigDecimals {

    public static BigDecimal TWO = BigDecimal.valueOf(2);
    
    private static final Map<Class<?>, Function<Number, BigDecimal>> decimalConversions;
    private static final Function<Number, BigDecimal> GENERIC_CONVERSION = n -> new BigDecimal(n.toString());

    static {
        final Map<Class<?>, Function<Number, BigDecimal>> funcs = new HashMap<>();
        funcs.put(BigDecimal.class, n -> (BigDecimal) n);
        funcs.put(BigInteger.class, n -> new BigDecimal((BigInteger) n));
        funcs.put(Integer.class, n -> BigDecimal.valueOf(n.intValue()));
        funcs.put(Long.class, n -> BigDecimal.valueOf(n.longValue()));
        decimalConversions = Collections.unmodifiableMap(funcs);
    }

    protected BigDecimals() {
    }

    @Nonnull
    public static BigDecimal toBigDecimal(@Nonnull final Number number) {
        return decimalConversions.getOrDefault(number.getClass(), GENERIC_CONVERSION).apply(number);
    }

    @Nonnull
    public static boolean isOne(@Nonnull final BigDecimal that) {
        return that == BigDecimal.ONE || that.compareTo(BigDecimal.ONE) == 0;
    }

    public static boolean valuesEqual(@Nullable final BigDecimal b1, @Nullable final BigDecimal b2) {
        return b1 == b2
                || (b1 != null && b2 != null && b1.compareTo(b2) == 0);
    }

}
