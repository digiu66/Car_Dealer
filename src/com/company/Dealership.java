package com.company;

import java.util.ArrayList;


public class Dealership {

    public ArrayList<Car> ownedCars;
    public Double cash = 25000.0;


    public void buyCar(Garage garage, int number) {
        if (cash >= garage.cars.get(number).value) {
            this.ownedCars.add(garage.cars.get(number));
            this.cash = cash - (garage.cars.get(number).value);
            garage.cars.remove(number);
            garage.cars.add(number, new Car());
        }
    }


     public void setOwnedCars(){
            this.ownedCars = new ArrayList<Car>();
        }
    }


