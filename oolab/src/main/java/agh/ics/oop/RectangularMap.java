package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    private final List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){
        if ( !(position.follows(new Vector2d(0,0))) || !(position.precedes(new Vector2d(this.width,this.height))) ){
            return false;
        }
        return !isOccupied(position);
    }

    public boolean isOccupied(Vector2d position){
        for (Animal i: animals){
            if (i.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    public Object objectAt(Vector2d position){
        for (Animal i: animals){
            if (i.getPosition().equals(position))
                return i;
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer newmap = new MapVisualizer(this);
        return newmap.draw(new Vector2d(0,0), new Vector2d(this.width,this.height));
    }
}
