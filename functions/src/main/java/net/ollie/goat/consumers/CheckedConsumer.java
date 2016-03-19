package net.ollie.goat.consumers;

import java.util.function.Consumer;

import javax.annotation.Nullable;

/**
 *
 * @author Ollie
 * @see Consumer
 */
public interface CheckedConsumer<T, X extends Exception> {

    void accept(@Nullable T t) throws X;

}
