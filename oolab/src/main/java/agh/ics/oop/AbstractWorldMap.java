package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {

    final Vector2d start_vector = new Vector2d(0,0);
    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grass = new ArrayList<>();
    protected List<IMapElement> mapElements = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        for (Animal value : this.animals) {
            if (value.isAt(animal.getPosition())) {
                return false;
            }
        }
        this.animals.add(animal);
        this.mapElements.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (int i = 1; i < this.mapElements.size(); i++) {
            if(this.mapElements.get(i).isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 1; i < this.mapElements.size(); i++) {
            if(this.mapElements.get(i).isAt(position)){
                return this.mapElements.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        Vector2d vector_right = start_vector;
        Vector2d vector_left = start_vector;
        for (Animal element : this.animals) {  //aby wyświetlała się również na mapie trawa to (IMapElement element : this.mapElements)
            vector_right = vector_right.upperRight(element.getPosition());
            vector_left = vector_left.lowerLeft(element.getPosition());
        }
        MapVisualizer newmap = new MapVisualizer(this);
        return newmap.draw(vector_left,vector_right);
    }

}
