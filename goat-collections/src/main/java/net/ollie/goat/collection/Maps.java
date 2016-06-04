package net.ollie.goat.collection;

import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author Ollie
 */
public abstract class Maps {

    protected Maps() {
    }

    public static <K, V1, V2> Map<K, V2> eagerlyTransformValues(final Map<K, V1> map, final Function< ? super V1, ? extends V2> transform) {
        throw new UnsupportedOperationException(); //TODO
    }

}
