package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {
    @Test
    void OrientationTest(){
        Animal pet1 = new Animal(new Vector2d(3, 2), MapDirection.WEST);
        Animal pet2 = new Animal(new Vector2d(3, 1), MapDirection.SOUTH);
        pet2.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, pet1.getOrientation());
        assertEquals(MapDirection.EAST, pet2.getOrientation());
    }

    @Test
    void PositionMoveTest(){
        Animal pet1 = new Animal(new Vector2d(2, 2), MapDirection.EAST);
        Animal pet2 = new Animal(new Vector2d(3, 1), MapDirection.SOUTH);
        pet1.move(MoveDirection.FORWARD);
        pet2.move(MoveDirection.RIGHT);
        pet2.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3,2), pet1.getPosition());
        assertEquals(new Vector2d(4,1), pet2.getPosition());
    }

    @Test
    void OutOfTheMapTest(){
        Animal animal1 = new Animal(new Vector2d(4, 4), MapDirection.EAST);
        animal1.move(MoveDirection.FORWARD);
        Animal animal2 = new Animal(new Vector2d(0, 0), MapDirection.NORTH);
        animal2.move(MoveDirection.BACKWARD);
        assertTrue(animal1.isAt(new Vector2d(4,4)));
        assertTrue(animal2.isAt(new Vector2d(0,0)));
    }

    @Test
    void InputTest(){
        Animal animal1 = new Animal(new Vector2d(2, 2), MapDirection.NORTH);
        String[] input = {"r", "f", "f", "f"};
        MoveDirection[] newargs = OptionsParser.parser(input);
        for(MoveDirection direction: newargs){
            animal1.move(direction);
        }
        assertEquals("Position: (4, 2), Orientation: Wschód", animal1.toString());
    }
}
