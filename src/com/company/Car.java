package com.company;

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
    public String[] status = new String[]{"Mint condition", "Broken brakes", "Alternator failure", "Overheating", "Blown fuse"};
    public String carCondition;
    public boolean isInspected;
    double brakesMultiplier = 0.05;
    double fuseMultiplier = 0.02;
    double overheatMultiplier = 0.03;
    double alternatorMultiplier = 0.09;

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


    public Car() {
        this.brand = getRandom(brandBase);
        this.color = getRandom(colorBase);
        this.mileage = randomMileage;
        this.carCondition = getRandom(status);
        this.isInspected = false;
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

    public void cheapRepairs(Dealership you) {
        int fate = ThreadLocalRandom.current().nextInt(0, 100 +1);
        double basePrice = 1500.0;
        if(fate < 5) {
            this.value = this.value - 0.2*this.value;
            System.out.println("Oh no! The mechanic only made it worse! You lost 20% of your car's worth.");
        }
        else {
            if(this.carCondition == "Mint condition") {
                System.out.println("This car is already in mint condition! No repairs needed.");
            } else {
                if(carCondition == "Broken brakes" && you.cash >= (basePrice + brakesMultiplier*this.value)) {
                    System.out.println("Jurij successfully repaired your car!");
                    you.cash = you.cash - (basePrice + brakesMultiplier*this.value);
                    System.out.println("You paid: " + (basePrice + brakesMultiplier*this.value));
                    this.carCondition = "Mint condition";
                    this.value = this.value + 0.25*this.value;
                } else if(carCondition == "Blown fuse" && you.cash >= (basePrice + fuseMultiplier*this.value)) {
                    System.out.println("Jurij successfully repaired your car!");
                    you.cash = you.cash - (basePrice + fuseMultiplier*this.value);
                    System.out.println("You paid: " + (basePrice + fuseMultiplier*this.value));
                    this.carCondition = "Mint condition";
                    this.value = this.value + 0.25*this.value;
                } else if (carCondition == "Overheating" && you.cash >= (basePrice + overheatMultiplier*this.value)) {
                    System.out.println("Jurij successfully repaired your car!");
                    you.cash = you.cash - (basePrice+ overheatMultiplier*this.value);
                    System.out.println("You paid: " + (basePrice + (overheatMultiplier*this.value)));
                    this.carCondition = "Mint condition";
                    this.value = this.value + 0.25*this.value;
                } else if(carCondition == "Alternator failure" && you.cash >= (basePrice + alternatorMultiplier*this.value)) {
                    System.out.println("Jurij successfully repaired your car!");
                    you.cash = you.cash - (basePrice + alternatorMultiplier*this.value);
                    System.out.println("You paid: " + (basePrice + alternatorMultiplier*this.value));
                    this.carCondition = "Mint condition";
                    this.value = this.value + 0.25*this.value;
                } else {
                    System.out.println("You cannot afford repairing this car.");
                }
            }
        }
    }

    public void standardRepairs(Dealership you) {
        double basePrice = 5000.0;
        if(this.carCondition == "Mint condition") {
            System.out.println("This car is already in mint condition! No repairs needed.");
        } else {
            if(carCondition == "Broken brakes" && you.cash >= (basePrice + brakesMultiplier*this.value)) {
                System.out.println("Andrzej successfully repaired your car!");
                you.cash = you.cash - (basePrice + brakesMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + brakesMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.35*this.value;
            } else if(carCondition == "Blown fuse" && you.cash >= (basePrice + fuseMultiplier*this.value)) {
                System.out.println("Andrzej successfully repaired your car!");
                you.cash = you.cash - (basePrice + fuseMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + fuseMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.35*this.value;
            } else if (carCondition == "Overheating" && you.cash >= (basePrice + overheatMultiplier*this.value)) {
                System.out.println("Andrzej successfully repaired your car!");
                you.cash = you.cash - (basePrice+ overheatMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + (overheatMultiplier*this.value)));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.35*this.value;
            } else if(carCondition == "Alternator failure" && you.cash >= (basePrice + alternatorMultiplier*this.value)) {
                System.out.println("Andrzej successfully repaired your car!");
                you.cash = you.cash - (basePrice + alternatorMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + alternatorMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.35*this.value;
            } else {
                System.out.println("You cannot afford to repair this car.");
            }

        }
        }


    public void deluxeRepairs(Dealership you) {
        double basePrice = 8000.0;
        if(this.carCondition == "Mint condition") {
            System.out.println("This car is already in mint condition! No repairs needed.");
        } else {
            if(carCondition == "Broken brakes" && you.cash >= (basePrice + brakesMultiplier*this.value)) {
                System.out.println("Johnson successfully repaired your car!");
                you.cash = you.cash - (basePrice + brakesMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + brakesMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.43*this.value;
            } else if(carCondition == "Blown fuse" && you.cash >= (basePrice + fuseMultiplier*this.value)) {
                System.out.println("Johnson successfully repaired your car!");
                you.cash = you.cash - (basePrice + fuseMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + fuseMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.43*this.value;
            } else if (carCondition == "Overheating" && you.cash >= (basePrice + overheatMultiplier*this.value)) {
                System.out.println("Johnson successfully repaired your car!");
                you.cash = you.cash - (basePrice+ overheatMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + (overheatMultiplier*this.value)));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.43*this.value;
            } else if(carCondition == "Alternator failure" && you.cash >= (basePrice + alternatorMultiplier*this.value)) {
                System.out.println("Johnson successfully repaired your car!");
                you.cash = you.cash - (basePrice + alternatorMultiplier*this.value);
                System.out.println("You paid: " + (basePrice + alternatorMultiplier*this.value));
                this.carCondition = "Mint condition";
                this.value = this.value + 0.43*this.value;
            } else {
                System.out.println("You cannot afford to repair this car.");
            }

        }

    }


    public String toString() {
        return "Brand: " + brand + ", Color: " + color + ", Mileage: " + mileage + ", Edition: " + edition +  ", Price: " + value + "\n";
    }
}
