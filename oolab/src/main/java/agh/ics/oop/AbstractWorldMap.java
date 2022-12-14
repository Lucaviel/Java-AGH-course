package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();
    protected MapBoundary mapBoundary=new MapBoundary();

    @Override
    public void place(Animal animal) {
        if (this.animalsMap.get(animal.getPosition()) != null) {
            throw new IllegalArgumentException(animal.getPosition()+ " is already occupied");
        }
        this.animalsList.add(animal);
        this.animalsMap.put(animal.getPosition(),animal);
        mapBoundary.put(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }
    /*
    protected abstract Vector2d calculateLowerBound();
    protected abstract Vector2d calculateUpperBound();
     */
    @Override
    public MapBoundary getBound(){ return this.mapBoundary; }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalsMap.containsKey(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animalsMap.remove(oldPosition);
            animalsMap.put(newPosition, a);
        }
    }

    public Vector2d getLowerLeftDrawLimit(){
        this.mapBoundary.sortComparator();
        int x = this.mapBoundary.xEl.get(0).getPosition().x;
        int y = this.mapBoundary.yEl.get(0).getPosition().y;
        return new Vector2d(x,y);
    }
    public Vector2d getUpperRightDrawLimit(){
        this.mapBoundary.sortComparator();
        int x = this.mapBoundary.xEl.get(this.mapBoundary.xEl.size()-1).getPosition().x;
        int y = this.mapBoundary.yEl.get(this.mapBoundary.yEl.size()-1).getPosition().y;
        return new Vector2d(x,y);
    }
    @Override
    public List<Animal> getAnimals(){
        return this.animalsList;
    }

}
