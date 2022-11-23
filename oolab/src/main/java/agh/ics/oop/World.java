package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {

/*      Vector2d v1 = new Vector2d(2, 5);
        Vector2d v2 = new Vector2d(1,-2);

        Vector2d v3 = v1.add(v2);
        System.out.println(v3);*/

/*      MapDirection position3 = MapDirection.NORTH;
        System.out.println(position3.next());
        System.out.println(position3.previous());
        Vector2d position4 = position3.toUnitVector();
        System.out.println(position4);

        System.out.println(Objects.equals(position1, position2));*/

/*        Animal pet1 = new Animal();
        System.out.println(pet1.getPosition());

        MoveDirection[] newargs = OptionsParser.parser(args);

        for(MoveDirection direction: newargs){
            pet1.move(direction);
        }

        System.out.println(pet1.toString());*/

        MoveDirection[] directions = new OptionsParser().parser(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
    }
}