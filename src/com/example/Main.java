package com.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Dot> dots = FileController.loadData("e.in.txt");

        if (dots == null) {
            FileController.saveData("e.out.txt", "No solution");
            System.out.println("No solution");
            return;
        }
        Polygon polygon = new Polygon(dots);
        System.out.println("Inner dots: " + polygon.getAmountOfInnerDots());

        FileController.saveData("e.out.txt", polygon.getAmountOfInnerDots().toString());
    }
}

//5
//-1 -1
//-2 1
//-1 3
//2 1
//1 -2

//6
//1 -1
//-2 2
//3 4
//1 1
//2 -1
//1 -3
