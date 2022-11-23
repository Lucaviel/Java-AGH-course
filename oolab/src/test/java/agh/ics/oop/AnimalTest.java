package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void OrientationTest(){
        IWorldMap map1 = new RectangularMap(3,2);
        Animal pet1 = new Animal(map1);
        IWorldMap map2 = new RectangularMap(3,1);
        Animal pet2 = new Animal(map2);

        pet2.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, pet1.getOrientation());
        assertEquals(MapDirection.WEST, pet2.getOrientation());
    }

    @Test
    void PositionMoveTest(){
        IWorldMap map1 = new RectangularMap(2,2);
        Animal pet1 = new Animal(map1);

        pet1.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,2), pet1.getPosition());
    }

    @Test
    void OutOfTheMapTest(){
        IWorldMap map1 = new RectangularMap(4,4);
        Animal animal1 = new Animal(map1);
        IWorldMap map2 = new RectangularMap(0,0);
        Animal animal2 = new Animal(map2);

        animal1.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.BACKWARD);
        assertFalse(animal1.isAt(new Vector2d(4,4)));
        assertFalse(animal2.isAt(new Vector2d(0,0)));
    }

    @Test
    void InputTest(){
        IWorldMap map1 = new RectangularMap(2,2);
        Animal animal1 = new Animal(map1);

        String[] input = {"r", "f", "f", "f"};
        MoveDirection[] newargs = OptionsParser.parser(input);
        for(MoveDirection direction: newargs){
            animal1.move(direction);
        }
        assertEquals("E", animal1.toString());
    }
}
