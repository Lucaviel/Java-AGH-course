package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {

    //private static final Vector2d LOWER_BOUND = new Vector2d(0,0)
    //private Vector2d position;
    private MapDirection orientation;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public String toString() {
        return switch(this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> { if(map.canMoveTo(this.position.add(this.orientation.toUnitVector()))){
                positionChanged(this.position,this.position.add(this.orientation.toUnitVector()));
                this.position = this.position.add(this.orientation.toUnitVector());}}
            case BACKWARD -> { if(map.canMoveTo(this.position.subtract(this.orientation.toUnitVector()))){
                positionChanged(this.position,this.position.subtract(this.orientation.toUnitVector()));
                this.position = this.position.subtract(this.orientation.toUnitVector());}}
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver Observer: this.observers) {
            Observer.positionChanged(oldPosition,newPosition);
        }
    }
}
