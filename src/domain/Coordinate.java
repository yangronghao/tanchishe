package domain;

import java.util.UnknownFormatConversionException;

public class Coordinate implements Cloneable {
    private int x;
    private int y;

    public Coordinate(int x,int y){
        this.x =x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Coordinate c = (Coordinate)obj;
        if (c.x != this.x)
            return false;
        return c.y == this.y;
    }

     Coordinate move(int i){
         i = amend(i);
        switch (i){
            case 1: return new Coordinate(x+1,y);
            case 2: return new Coordinate(x,y+1);
            case 3: return new Coordinate(x-1,y);
            default:return new Coordinate(x,y-1);
        }
    }
    //修正方向超出值
    private int amend(int fx){
        fx = fx > 4?(fx-4):fx;
        fx = fx < 1?(fx+4):fx;
        return fx;
    }
    public Object clone() {
        Coordinate o = null;
        try {
            o = (Coordinate) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    int getfx(Coordinate c){
        if (c.x > x)
            return 1;
        if (c.x < x)
            return 3;
        if (c.y > y)
            return 2;
        return 4;
    }

   boolean hasX(int x){
        return this.x == x;
    }
    boolean hasY(int y){
        return this.y == y;
    }

}
