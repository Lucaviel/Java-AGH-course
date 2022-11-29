package agh.ics.oop;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    final Vector2d start_vector = new Vector2d(0,0);
    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();

    @Override
    public boolean place(Animal animal) {
        if (this.animalsMap.get(animal.getPosition()) != null) {
            return false;
        }
        this.animalsList.add(animal);
        this.animalsMap.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) == null)
            return false;
        return true;
    }
    /*
    protected abstract Vector2d calculateLowerBound();
    protected abstract Vector2d calculateUpperBound();
     */

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animalsMap.containsKey(position));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animalsMap.remove(oldPosition);
            animalsMap.put(newPosition, a);
        }
    }
    public List<Animal> getAnimals(){
        return this.animalsList;
    }

}
