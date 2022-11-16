package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parser(String[] args){
        MoveDirection[] news = new MoveDirection [args.length];
        for(int i=0; i < args.length; i++){
            switch (args[i]) {
                case "f", "forward" -> news[i] = MoveDirection.FORWARD;
                case "b", "backward" -> news[i] = MoveDirection.BACKWARD;
                case "r", "right" -> news[i] = MoveDirection.RIGHT;
                case "l", "left" -> news[i] = MoveDirection.LEFT;
            }
        }
        return news;
    }
}
