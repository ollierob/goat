package net.ollie.goat.suppliers.lazy;

import net.ollie.goat.suppliers.lazy.LoadOnceVolatileLazy;

import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Ollie
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class LoadOnceVolatileLazyTest {

    @Mock
    private Supplier<Object> mockSupplier;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLoadOnce() {
        final Object object = new Object();
        when(mockSupplier.get()).thenReturn(object);
        final LoadOnceVolatileLazy<Object> lazy = new LoadOnceVolatileLazy<>(mockSupplier);
        assertThat(lazy.get(), is(object));
        assertThat(lazy.get(), is(object));
        assertThat(lazy.get(), is(object));
        assertThat(lazy.get(), is(object));
        assertThat(lazy.get(), is(object));
        verify(mockSupplier, times(1)).get();
    }

}
