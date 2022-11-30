package agh.ics.oop;
import java.lang.Math;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    public GrassField(int n){
        int max = (int)Math.sqrt(n*10);
        int count = 0;
        Random r = new Random();
        while(count <= n){
            int x = r.nextInt(max);
            int y = r.nextInt(max);
            Grass temp = new Grass(new Vector2d(x,y));
            if(this.grass.contains(temp))
                continue;
            count++;
            this.grass.add(temp);
            this.mapElements.add(temp);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}
