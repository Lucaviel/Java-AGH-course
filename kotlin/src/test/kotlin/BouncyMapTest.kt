import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BouncyMapTest {  // podane zależności dla gradle'a nie chciały mi się załadować poprawnie

    val world = BouncyMap(5,5)
    val pet1 = Animal(map=world)
    val pet2 = Animal(position = Vector2d(2,3), map=world)
    init{
    world.place(pet1)
        world.place(pet2)
    }

    @Test
    fun canMoveTo() {
        val exp1 = world.canMoveTo(Vector2d(2,3))
        assertEquals(exp1, false)

        val exp2 = world.canMoveTo(Vector2d(4,5))
        assertEquals(exp2, true)
    }

    @Test
    fun place() {
    val pet3 = Animal(position = Vector2d(2,3), map=world)
        world.place(pet3)
        assertTrue(pet3.position != Vector2d(2,3))
    }

    @Test
    fun isOccupied() {
        val exp = world.isOccupied(Vector2d(2,3))
        assertEquals(exp, true)
    }

    @Test
    fun objectAt() {
        val exp = world.objectAt(Vector2d(4,2))
        assertEquals(exp, null)
    }
}