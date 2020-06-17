package com.company;

import java.util.ArrayList;

public class Garage {

    ArrayList<Car> cars = new ArrayList<>(5);

    public ArrayList<Car> fillCarBase() {
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        return cars;
    }

    public void setCars() {
        this.fillCarBase();
    }

    public ArrayList<Car> rerollCars() {
        cars.clear();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        return cars;
    }
}
