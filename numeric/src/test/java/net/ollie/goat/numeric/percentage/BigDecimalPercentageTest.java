package net.ollie.goat.numeric.percentage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class BigDecimalPercentageTest {

    @Test
    public void testToString() {
        assertThat("1%", BigDecimalPercentage.ONE_PERCENT.toString(), is("1%"));
        assertThat("100%", BigDecimalPercentage.ONE_HUNDRED_PERCENT.toString(), is("100%"));
    }

}
