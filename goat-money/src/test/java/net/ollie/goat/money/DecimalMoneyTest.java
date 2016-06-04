package net.ollie.goat.money;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

import net.ollie.goat.currency.Currency;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class DecimalMoneyTest {

    @Test
    public void testToString() {
        final Currency mockCurrency = new Currency() {

            @Override
            public String symbol() {
                throw new UnsupportedOperationException(); //TODO
            }

            @Override
            public String uniqueSymbol() {
                return "DEF";
            }

        };
        assertThat(new DecimalMoney(mockCurrency, BigDecimal.ONE).toString(), is("DEF 1"));
    }

}
