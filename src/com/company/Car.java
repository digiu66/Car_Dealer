package com.company;

import java.util.ArrayList;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car {
    public Double value;
    public String brand;
    public String[] brandBase = new String[]{"Honda", "Polonez", "Daewoo", "BMW", "Ford", "Toyota", "Tesla", "Mercedes", "Chrysler"};
    public Integer mileage;
    public String color;
    public String[] colorBase = new String[]{"Red", "Blue", "Yellow", "Green", "Black", "Grey"};
    public String edition;
    public String[] editionBase = new String[]{"budget", "standard", "premium"};
    int randomMileage = ThreadLocalRandom.current().nextInt(5000, 100000 + 1);
    double randomPriceBudget = ThreadLocalRandom.current().nextInt(3000, 15000 + 1);
    double randomPriceStandard = ThreadLocalRandom.current().nextInt(15001, 50000 + 1);
    double randomPricePremium = ThreadLocalRandom.current().nextInt(50001, 150000);


    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    public Car() {
        this.brand = getRandom(brandBase);
        this.color = getRandom(colorBase);
        this.mileage = randomMileage;
        if(this.brand == "Honda" || this.brand == "Polonez" || this.brand == "Daewoo") {
            this.edition = editionBase[0];
            this.value = randomPriceBudget;
        } else if(this.brand == "BMW" || this.brand == "Ford" || this.brand == "Toyota") {
            this.edition = editionBase[1];
            this.value = randomPriceStandard;
        } else {
            this.edition = editionBase[2];
            this.value = randomPricePremium;
        }
    }

    public static ArrayList<Car> fillCarBase() {
        ArrayList<Car> carbase = new ArrayList<>();
        carbase.add(new Car());
        carbase.add(new Car());
        carbase.add(new Car());
        carbase.add(new Car());
        carbase.add(new Car());
        return carbase;
    }


    public String toString() {
        return "Brand: " + brand + ", Color: " + color + ", Mileage: " + mileage + ", Edition: " + edition +  ", Price: " + value + "\n";
    }
}
