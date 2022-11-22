package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class SimulationEngine implements IEngine{

    private final MoveDirection[] directions;
    private final IWorldMap map;
    private Vector2d[] positions;
    private List<Animal> animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            map.place(animal);
            animals.add(animal);
        }
    }

    public void run(){
        for (int i=0; i< directions.length; i++){
            Animal animal = this.animals.get(i% animals.size());
            animal.move(directions[i]);
        }
    }
}
