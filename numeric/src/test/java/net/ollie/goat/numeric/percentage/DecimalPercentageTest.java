package net.ollie.goat.numeric.percentage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ollie
 */
public class DecimalPercentageTest {

    @Test
    public void testReciprocal() {
        assertThat(DecimalPercentage.ZERO_PERCENT.reciprocal(), is(DecimalPercentage.ONE_HUNDRED_PERCENT));
    }

}
