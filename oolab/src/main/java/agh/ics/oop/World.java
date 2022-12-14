package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try{
            Application.launch(App.class, args);
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
        ///f b f b f b f b f b f b f b f b r l f f f f f f f f f f
//        MoveDirection[] directions = new OptionsParser().parser(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        IWorldMap map=new GrassField(10);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        System.out.println(map);
    }
}