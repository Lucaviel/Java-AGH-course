package agh.ics.oop;

import java.util.Objects;

public class World {
    public static void run(Direction[] directions){
    /*    System.out.println("Zwierzak porusza się do przodu");

       for(int i=0; i < directions.length-1; i++){
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

/*    public static Direction[] changing(String [] olds){
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
    }*/

    public static void main(String[] args) {
/*        System.out.println("system wystartował");

        Direction[] newargs = changing(args);
        run(newargs);

        System.out.println("system zakończył działanie");
    } */

/*      Vector2d v1 = new Vector2d(2, 5);
        Vector2d v2 = new Vector2d(1,-2);

        Vector2d v3 = v1.add(v2);
        System.out.println(v3);*/

/*      MapDirection position3 = MapDirection.NORTH;
        System.out.println(position3.next());
        System.out.println(position3.previous());
        Vector2d position4 = position3.toUnitVector();
        System.out.println(position4);

        System.out.println(Objects.equals(position1, position2));*/

        Animal pet1 = new Animal();
        System.out.println(pet1.getPosition());

        MoveDirection[] newargs = OptionsParser.parser(args);

        for(MoveDirection direction: newargs){
            pet1.move(direction);
        }

        System.out.println(pet1.toString());
    }
}

// aby zaimplementować mechanizm, który wyklucza pojawienie sie dwóch zwierząt w tym samym miejscu należałoby użyć metody isAt,
// która po wykonaniu switcha w metodzie move sprawdzałaby pozycje każdego obiektu klasy Animal, czy jest równa pozycji naszego
// aktualnego obiektu. Jeśli nie to nic się nie dzieje, jeśli tak to przechodzimy do innej metody/kolejnego switcha w metodzie
// move, gdzie ruch byłby cofnięty. Oczywiście każdy obiekt musiałby być automatycznie zapisany w pewnym zbiorze, kolekcji.