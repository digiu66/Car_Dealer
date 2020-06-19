package com.company;

import java.util.ArrayList;

public class Garage {

    ArrayList<Car> cars = new ArrayList<>();

    public void fillCarBase() {
        for(int i = 0; i < 5; i++) {
            cars.add(new Car());
        }
    }

    public void setCars() {
        this.fillCarBase();
    }

    public void rerollCars() {
        cars.clear();
        for(int i = 0; i < 5; i++) {
            cars.add(new Car());
        }
    }
}
