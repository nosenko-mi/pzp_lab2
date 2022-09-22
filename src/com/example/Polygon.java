package com.example;

import java.util.ArrayList;

public class Polygon {
    private final ArrayList<Dot> coordinates;

    public Polygon(ArrayList<Dot> coordinates) {
        this.coordinates = coordinates;
    }

    public Double getArea() {
//        формула площі Гаусса
        double x = 0;
        double y = 0;
        for (int i = 0; i < coordinates.size() - 1; i++) {
            x += coordinates.get(i).getX() * coordinates.get(i + 1).getY();
            y += coordinates.get(i).getY() * coordinates.get(i + 1).getX();
        }
//        ще одне додавання тому, що це вихід за межі масиву
        x += coordinates.get(coordinates.size() - 1).getX() * coordinates.get(0).getY();
        y += coordinates.get(coordinates.size() - 1).getY() * coordinates.get(0).getX();

        return Math.abs((x - y) / 2);
    }

    public Double getAmountOfDots(){
//        n = gcd(|x₂ − x₁|, |y₂ − y₁|)
        Double amount = 0.0;
        for (int i = 0; i < coordinates.size() - 1; i++){
            Double x, y;
            x = Math.abs(coordinates.get(i + 1).getX() - coordinates.get(i).getX());
            y = Math.abs(coordinates.get(i + 1).getY() - coordinates.get(i).getY());
            double tmp = gcd(x.intValue(), y.intValue());
            amount += gcd(x.intValue(), y.intValue());
        }
        Double x, y;
        x = Math.abs(coordinates.get(coordinates.size() - 1).getX() - coordinates.get(0).getX());
        y = Math.abs(coordinates.get(coordinates.size() - 1).getY() - coordinates.get(0).getY());
        amount += gcd(x.intValue(), y.intValue());

        return amount;
    }

    public Integer getAmountOfInnerDots(){
//        S = innerPoints + outerPoints/2 - 1
//        innerPoints = S - outerPoints/2 + 1
        double result = getArea() - getAmountOfDots() / 2 + 1;
        return (int) result;
    }

    private Integer gcd(int n1, int n2){
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
