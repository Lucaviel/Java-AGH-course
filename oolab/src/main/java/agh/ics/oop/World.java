package agh.ics.oop;

import java.util.Objects;

public class World {
    public static void run(Direction[] directions){
        System.out.println("Zwierzak porusza się do przodu");

/*       for(int i=0; i < directions.length-1; i++){
            System.out.print(directions[i] + ", ");
       }
       System.out.println(directions[directions.length-1]);

       String joinedDirections = String.join(", ", directions);
       System.out.println(joinedDirections);*/

       for(Direction direction: directions){
            switch(direction){
                case FORWARD -> System.out.println("Zwierzak porusza się do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
       }
    }

    public static Direction[] changing(String [] olds){
        Direction[] news = new Direction [olds.length];
        for(int i=0; i < olds.length; i++){
            if(olds[i].equals("f")){
                news[i] = Direction.FORWARD;
            }
            else if (olds[i].equals("b")){
                news[i] = Direction.BACKWARD;
            }
            else if (olds[i].equals("r")){
                news[i] = Direction.RIGHT;
            }
            else if (olds[i].equals("l")){
                news[i] = Direction.LEFT;
            }
        }
        return news;
    }

    public static void main(String[] args) {
/*        System.out.println("system wystartował");

        if (args != null){
            System.out.println("Start");
        }

        Direction[] newargs = changing(args);
        run(newargs);

        if (args != null){
            System.out.println("Stop");
        }
        System.out.println("system zakończył działanie");
    } */

/*        Vector2d v1 = new Vector2d(2, 5);
        System.out.println(v1);

        Vector2d v2 = new Vector2d(1,-2);

        Vector2d v3 = v1.add(v2);
        System.out.println(v3);

        System.out.println(v1.precedes(v3));
        System.out.println(v1.follows(v3));

        Vector2d v4 = v2.upperRight(v1);
        System.out.println(v4);*/

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection position3 = MapDirection.NORTH;
        System.out.println(position3.next());
        System.out.println(position3.previous());
        Vector2d position4 = position3.toUnitVector();
        System.out.println(position4);

        System.out.println(Objects.equals(position1, position2));

    }
}
