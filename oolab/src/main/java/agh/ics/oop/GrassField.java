package agh.ics.oop;
import java.lang.Math;
import java.util.*;

public class GrassField extends AbstractWorldMap {

    protected Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int n) {
        int max = (int) Math.sqrt(n * 10);
        Integer[] varX = new Integer[max];
        Integer[] varY = new Integer[max];
        for (int i = 0; i < max; i++) {
            varX[i] = i;
            varY[i] = i;
        }
        Collections.shuffle(Arrays.asList(varX));
        Collections.shuffle(Arrays.asList(varY));
        for (int i = 0; i < max; i++) {
            Grass temp = new Grass(new Vector2d(varX[i], varY[i]));
            this.grass.put(temp.getPosition(),temp);
        }
    }

    @Override
    public String toString() {
        Set<Vector2d> animals_set = this.animalsMap.keySet();
        Set<Vector2d> grass_set = this.grass.keySet();
        Vector2d vectorRight = start_vector;
        Vector2d vectorLeft = start_vector;
        for (Vector2d vector : animals_set) {
            vectorRight = vectorRight.upperRight(vector);
            vectorLeft = vectorLeft.lowerLeft(vector);
        }
        for (Vector2d vector : grass_set) {
            vectorRight = vectorRight.upperRight(vector);
            vectorLeft = vectorLeft.lowerLeft(vector);
        }
        MapVisualizer newmap = new MapVisualizer(this);
        return newmap.draw(vectorLeft,vectorRight);
    }

//    @Override
//    public boolean canMoveTo(Vector2d position){
//            return super.canMoveTo(position);
//        }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animalsMap.get(position) != null){
            return this.animalsMap.get(position);
        }
        if(this.grass.get(position) != null){
            return this.grass.get(position);
        }
        return null;
    }
}
