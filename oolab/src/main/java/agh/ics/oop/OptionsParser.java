package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parser(String[] args){
        //returnStream.of(input)
        //  .map(instruction -> switch (instruction){
        //      case "f", "forward" -> news[i] = MoveDirection.FORWARD;
        //      case "b", "backward" -> news[i] = MoveDirection.BACKWARD;
        //      case "r", "right" -> news[i] = MoveDirection.RIGHT;
        //      case "l", "left" -> news[i] = MoveDirection.LEFT;
        //      default -> null;
        // }).filter(MoveDirection -> MoveDirection != null)
        //.toArray(MoveDirection[]::new);
        MoveDirection[] news = new MoveDirection [args.length];
        int i = 0;
        for(String arg: args){
            news[i] = switch (args[i]) {
                case "f", "forward" -> news[i] = MoveDirection.FORWARD;
                case "b", "backward" -> news[i] = MoveDirection.BACKWARD;
                case "r", "right" -> news[i] = MoveDirection.RIGHT;
                case "l", "left" -> news[i] = MoveDirection.LEFT;
                default -> throw new IllegalArgumentException( "Nieprawidłowa instrukcja!" );
            };
            i++;
        }
        return news;
    }
    //
}
