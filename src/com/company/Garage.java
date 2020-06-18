package com.company;

import java.util.ArrayList;

public class Garage {

    ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> fillCarBase() {
        for(int i = 0; i < 5; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void setCars() {
        this.fillCarBase();
    }

    public ArrayList<Car> rerollCars() {
        cars.clear();
        for(int i = 0; i < 5; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
