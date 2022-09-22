package com.example;

public class Dot {

    private Double x;
    private Double y;

    public Dot(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getDistanceTo(Dot dot){
        return Math.sqrt(Math.pow((x - dot.x), 2) + Math.pow((y - dot.y), 2));
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
