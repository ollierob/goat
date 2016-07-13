package net.ollie.goat.numeric.fraction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class DecimalFractionTest {

    @Test
    public void testToDouble() {
        assertThat(DecimalFraction.of(1, 2).doubleValue(), is(0.5d));
        assertThat(DecimalFraction.of(1, 4).doubleValue(), is(0.25d));
    }

    @Test
    public void testEquality() {
        assertThat(DecimalFraction.of(2, 4), is(DecimalFraction.of(1, 2)));
        assertThat(DecimalFraction.of(2, 6), is(DecimalFraction.of(1, 3)));
    }

    @Test
    public void testMultiplication() {
        assertThat(DecimalFraction.of(2, 3).times(DecimalFraction.of(5, 7)), is(DecimalFraction.of(10, 21)));
    }

    @Test
    public void testCompare() {
        final DecimalFraction d1 = DecimalFraction.of(1, 2);
        final DecimalFraction d2 = DecimalFraction.of(1, 3);
        assertThat(d1.compareTo(d1), is(0));
        assertTrue(d1.compareTo(d2) > 0);
        assertTrue(d2.compareTo(d1) < 0);
    }

    @Test
    public void testAdd() {
        assertThat(DecimalFraction.of(1, 2).plus(DecimalFraction.of(2, 3)), is(DecimalFraction.of(7, 6)));
    }

    @Test
    public void testIsReduced() {
        assertTrue("1/2", DecimalFraction.of(1, 2).isReduced());
        assertFalse("2/4", DecimalFraction.of(2, 4).isReduced());
        assertTrue("1/3", DecimalFraction.of(1, 3).isReduced());
        assertFalse("2/6", DecimalFraction.of(2, 6).isReduced());
        assertTrue("-1/3", DecimalFraction.of(-1, 3).isReduced());
        assertTrue("-1/3", DecimalFraction.of(1, -3).isReduced());
        assertFalse("-2/3", DecimalFraction.of(-2, 6).isReduced());
        assertFalse("-2/3", DecimalFraction.of(2, -6).isReduced());
        assertFalse("4/8", DecimalFraction.of(4, 8).isReduced());
        assertTrue("3/7", DecimalFraction.of(3, 7).isReduced());
    }

}
