package agh.ics.oop;

public class World {
    public static void run(Direction[] directions){
        // System.out.println("Zwierzak porusza się do przodu");

       // for(int i=0; i < directions.length-1; i++){
       //     System.out.print(directions[i] + ", ");
       // }
       // .out.println(directions[directions.length-1]);

        // String joinedDirections = String.join(", ", directions);
        // System.out.println(joinedDirections);

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
        System.out.println("system wystartował");

        if (args != null){
            System.out.println("Start");
        }

        Direction[] newargs = changing(args);
        run(newargs);

        if (args != null){
            System.out.println("Stop");
        }
        System.out.println("system zakończył działanie");
    }
}
