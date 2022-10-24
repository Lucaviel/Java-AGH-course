package agh.ics.oop;

public class Animal {
    private Vector2d position;
    private MapDirection orientation;

    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d position, MapDirection orientation){
        this.position = position;
        this.orientation = orientation;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        return "Position: " + position.toString() + ", Orientation: " + orientation.toString();
    }

    boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch (direction) {
                case LEFT -> this.orientation = this.orientation.previous();
                case RIGHT -> this.orientation = this.orientation.next();
                case FORWARD -> this.position = this.position.add(this.orientation.toUnitVector());
                case BACKWARD -> this.position = this.position.subtract(this.orientation.toUnitVector());
        }

        if(!(this.position.precedes(new Vector2d(4,4))) || !(this.position.follows(new Vector2d(0,0)))){
            switch(direction){
                case FORWARD -> this.position = this.position.add(this.orientation.toUnitVector().opposite());
                case BACKWARD -> this.position = this.position.subtract(this.orientation.toUnitVector().opposite());
            }
        }
    }
}
