package net.ollie.goat.collectors;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import static net.ollie.goat.collectors.PairCollectors.pairs;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class PairCollectorsTest {

    @Test
    public void shouldCollectPairsToList() {
        final List<Integer> integers = Arrays.asList(2, 3, 5, 7);
        final List<Integer> multiplied = integers.stream().collect(pairs((a, b) -> a * b));
        assertThat(multiplied, contains(6, 15, 35));
    }

}
