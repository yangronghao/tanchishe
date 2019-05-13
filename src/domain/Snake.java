package domain;

import java.util.List;

public class Snake {
    private List<Coordinate> coordinateList;
    private int fx = 1;
    private int size;

    public Snake(List<Coordinate> coordinateList){
        this.coordinateList = coordinateList;
        size = coordinateList.size();
    }

    public boolean move(Coordinate coordinate){
        Coordinate cd = coordinateList.get(size - 1);
        Coordinate move = cd.move(fx);
        if (coordinate.equals(move)){
            //吃到了点
            size++;
            coordinateList.add(move);
            return true;
        }
        int x = move.getX();
        int y = move.getY();
        if(coordinateList.contains(move)||x <0||x>16||y<0||x>16){
            //吃到了自己 或撞了墙
            return false;
        }
        coordinateList.remove(0);
        coordinateList.add(move);
        return true;
    }

}