package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {

    //private static final Vector2d LOWER_BOUND = new Vector2d(0,0)
    //private Vector2d position;
    private MapDirection orientation;
    private final IWorldMap map;

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

//    public Vector2d getPosition() {
//        return position;
//    }

    public String toString() {
        return switch(this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

//    public boolean isAt(Vector2d position) {
//        return this.position.equals(position);
//    }   /*Objects.equals(this.position, other.position)*/

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> { if(map.canMoveTo(this.position.add(this.orientation.toUnitVector()))){
                this.position = this.position.add(this.orientation.toUnitVector());}}
            case BACKWARD -> { if(map.canMoveTo(this.position.subtract(this.orientation.toUnitVector()))){
                this.position = this.position.subtract(this.orientation.toUnitVector());}}
        }
    }
}
