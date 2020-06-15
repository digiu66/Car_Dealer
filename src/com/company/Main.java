package com.company;


import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {

        ArrayList<Car> garage = Car.fillCarBase();
        System.out.println(garage);

        System.out.println(garage.get(2));

    }
}
