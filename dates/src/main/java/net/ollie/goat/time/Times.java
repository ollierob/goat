package net.ollie.goat.time;

import java.time.Instant;

import net.ollie.goat.functions.Functions;

/**
 *
 * @author Ollie
 */
public class Times {

    protected Times() {
    }

    public static boolean equals(final Instant left, final Instant right) {
        return Functions.ifBothNonNull(left, right, Instant::equals);
    }

}
