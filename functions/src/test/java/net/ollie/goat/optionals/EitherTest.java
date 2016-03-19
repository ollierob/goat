package net.ollie.goat.optionals;

import net.ollie.goat.optionals.Either;

import java.util.Optional;
import java.util.function.Consumer;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class EitherTest {

    @Test
    public void testLeft_Left() {
        final Object value = new Object();
        this.testLeft(Either.left(value), value);
    }

    @Test
    public void testLeft_Either() {
        final Object value = new Object();
        this.testLeft(Either.either(() -> value, () -> new Object()), value);
    }

    private void testLeft(final Either<Object, Object> either, final Object value) {

        assertThat(either.left(), is(Optional.of(value)));
        assertThat(either.right(), is(Optional.empty()));

        final Consumer<Object> mockLeftConsumer = mock(Consumer.class);
        final Consumer<Object> mockRightConsumer = mock(Consumer.class);
        either.consume(mockLeftConsumer, mockRightConsumer);
        verify(mockLeftConsumer, times(1)).accept(eq(value));
        verify(mockLeftConsumer, times(0)).accept(any(Object.class));
        verifyNoMoreInteractions(mockLeftConsumer, mockRightConsumer);

    }

}
