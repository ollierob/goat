package net.ollie.goat.consumers;

import java.util.function.Consumer;

/**
 *
 * @author Ollie
 */
public final class Consumers {
    
    private Consumers() {}
    
    public static <T> Consumer<T> ignore() {
        return object -> {};
    }

}
