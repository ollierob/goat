package net.ollie.goat.currency;

import javax.annotation.Nonnull;

import net.ollie.goat.numeric.percentage.DecimalPercentage;
import net.ollie.goat.numeric.percentage.Percentage;

/**
 *
 * @author Ollie
 */
public interface Currency extends HasCurrencyId {

    Percentage STANDARD_PIP = DecimalPercentage.basisPoints(1);

    @Nonnull
    String symbol();

    @Nonnull
    String uniqueSymbol();

    @Nonnull
    default Percentage pip() {
        return STANDARD_PIP;
    }

}
