package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Vector2dTest {
    @Test
    void ShouldGetString() {
        assertEquals("(2, 3)", new Vector2d(2, 3).toString());
    }

    @Test
    void ShouldBeAdded() {
        assertEquals(new Vector2d(3, 10), new Vector2d(4, 6).add(new Vector2d(-1, 4)));
    }

    @Test
    void ShouldShowRightUpper() {
        assertEquals(new Vector2d(4, 6), new Vector2d(4, 6).upperRight(new Vector2d(-1, 4)));
    }

    @Test
    void ShouldShowLeftLower() {
        assertEquals(new Vector2d(-1, 4), new Vector2d(4, 6).lowerLeft(new Vector2d(-1, 4)));
    }

    @Test
    void ShouldBeSubtracted() {
        assertEquals(new Vector2d(5, 2), new Vector2d(4, 6).subtract(new Vector2d(-1, 4)));
    }

    @Test
    void ShouldBeOpposite() {

        assertEquals(new Vector2d(-1, 3), new Vector2d(1, -3).opposite());
    }

    @Test
    void ShouldPrecede() {
        assertTrue(new Vector2d(4, 6).precedes(new Vector2d(5, 6)));
    }

    @Test
    void ShouldFollow() {
        assertTrue(new Vector2d(4, 6).follows(new Vector2d(4, 3)));
    }

    @Test
    void ShouldBeEqual() {
        assertEquals(new Vector2d(4, 6), new Vector2d(4, 6));
    }

}
