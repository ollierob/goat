package net.ollie.goat.numeric;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class BigDecimalsTest {

    @Test
    public void shouldConvert_Long_Wrap() {
        final long l = (long) Integer.MAX_VALUE + (long) Integer.MAX_VALUE + 2L;
        assertTrue(l > 0);
        assertTrue((int) l == 0);
        assertThat(BigDecimals.toBigDecimal(l), not(BigDecimal.ZERO));
    }

}
