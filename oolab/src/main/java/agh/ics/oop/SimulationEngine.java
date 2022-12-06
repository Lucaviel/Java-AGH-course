package agh.ics.oop;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] directions;
    private final IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for (Vector2d p : positions) {
            Animal animal=new Animal(map, p);
            animal.addObserver(map);
            map.place(animal);
        }
    }

    public void run(){
        int i = 0;
        while (i < directions.length) {
            for (Animal a : ((AbstractWorldMap) map).getAnimals()) {
                if (i == directions.length) break;
                a.move(directions[i]);
                i++;
            }
        }
    }
}
