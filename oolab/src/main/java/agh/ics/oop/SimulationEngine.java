package agh.ics.oop;

import agh.ics.oop.gui.App;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{

    private MoveDirection[] directions = new MoveDirection[]{};
    private final IWorldMap map;

    App renderer;
    int index;
    int delay = 100;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for (Vector2d p : positions) {
            Animal animal=new Animal(map, p);
            animal.addObserver(map);
            map.place(animal);
        }
    }

    public SimulationEngine(AbstractWorldMap map_animals, Vector2d[] positions,App renderer){
        this.renderer = renderer;
        this.map = map_animals;
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map, position);
            animal.addObserver(map_animals);
            if (renderer != null){
                animal.addObserver(renderer);
            }
            this.map.place(animal);
        }
        this.map.getBound().sortComparator();
    }

    @Override
    public void run() {
        if (renderer != null)
            this.renderer.render();
        List<Animal> animals = this.map.getAnimals();
        this.index += 1;
        for (int i=0;i<this.directions.length;i++){
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                System.out.println("Error: Przerwano symulacje!");
                throw new RuntimeException(e);
            }
            animals.get(i%animals.size()).move(this.directions[i]);
        }
    }

    public void setDelay(int moveDelay){
        this.delay = moveDelay;
    }
    public void setMoves(MoveDirection[] moves) {
        this.directions = moves;
    }
}
