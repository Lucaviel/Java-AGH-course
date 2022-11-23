package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngineTest {

    @Test
    public void testSimulationEngine(){
        Vector2d[] positions1 = new Vector2d[] {new Vector2d(2, 2), new Vector2d(3,4)};

        MoveDirection[] moves1 = OptionsParser.parser(new String[] {"f", "b", "r", "l", "r", "f", "b", "b", "l"});
        IWorldMap map1 = new RectangularMap(6, 5);
        IEngine engine1 = new SimulationEngine(moves1, map1, positions1);
        List<Animal> animals1 = new ArrayList<>();
        animals1.add((Animal) map1.objectAt(new Vector2d(2, 2)));
        animals1.add((Animal) map1.objectAt(new Vector2d(3,4)));

        engine1.run();

        assertEquals(animals1.get(0), map1.objectAt(new Vector2d(2, 4)));
        assertEquals(animals1.get(1), map1.objectAt(new Vector2d(4, 3)));

        Vector2d[] positions2 = new Vector2d[] {new Vector2d(2, 2), new Vector2d(1,2), new Vector2d(5, 3)};

        MoveDirection[] moves2 = OptionsParser.parser(new String[] {"f", "b", "r", "l","f","f","r","r","f","f","f","f","f","f","f","f"});
        IWorldMap map2 = new RectangularMap(5, 8);
        IEngine engine2 = new SimulationEngine(moves2, map2, positions2);
        List<Animal> animals2 = new ArrayList<>();
        animals2.add((Animal) map2.objectAt(new Vector2d(2,2)));
        animals2.add((Animal) map2.objectAt(new Vector2d(1,2)));
        animals2.add((Animal) map2.objectAt(new Vector2d(5,3)));

        engine2.run();

        assertEquals(animals2.get(0), map2.objectAt(new Vector2d(2, 6)));
        assertEquals(animals2.get(1), map2.objectAt(new Vector2d(3, 2)));
        assertEquals(animals2.get(2), map2.objectAt(new Vector2d(5, 3)));
    }


}