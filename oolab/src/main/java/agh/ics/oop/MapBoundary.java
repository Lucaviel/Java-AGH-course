package agh.ics.oop;
import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    public List<AbstractWorldMapElement> xEl = new ArrayList<>();
    public List<AbstractWorldMapElement> yEl = new ArrayList<>();
    Comparator<AbstractWorldMapElement> yComparator = (o1, o2) -> {
        if (o1.getPosition().y == o2.getPosition().y){
            return Integer.compare(o1.getPosition().x, o2.getPosition().x);}
        return Integer.compare(o1.getPosition().y, o2.getPosition().y);
    };
    Comparator<AbstractWorldMapElement> xComparator = (o1, o2) -> {
        if (o1.getPosition().x == o2.getPosition().x)
            return Integer.compare(o1.getPosition().y, o2.getPosition().y);
        return Integer.compare(o1.getPosition().x, o2.getPosition().x);
    };

    public void put(AbstractWorldMapElement Element){
        this.xEl.add(Element);
        this.yEl.add(Element);
    }
    public void sortComparator(){
        xEl.sort(xComparator);
        yEl.sort(yComparator);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}