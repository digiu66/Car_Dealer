package com.company;

import java.util.ArrayList;


public class Dealership {

    public ArrayList<Car> ownedCars;
    public Double cash = 25000.0;
    public Integer transactionCounter = 0;


    public void buyCar(Garage garage, int number) {
        if (cash >= garage.cars.get(number).value) {
            this.ownedCars.add(garage.cars.get(number));
            this.cash = cash - (garage.cars.get(number).value);
            garage.cars.remove(number);
            garage.cars.add(number, new Car());
            System.out.println("You bought a car. Your current stock:\n" + this.ownedCars);
        } else {
            System.out.println("The car you chose is too expensive. Try another one.");
        }
        System.out.println("Your current cash: " + this.cash);
    }

    public void sellCar(int number, Client client) {
        if (client.money >= this.ownedCars.get(number).value) {
            if (client.likedBrand1 == this.ownedCars.get(number).brand || client.likedBrand2 == this.ownedCars.get(number).brand) {
                double tax = 0.02 * this.ownedCars.get(number).value;
                this.cash = this.cash + this.ownedCars.get(number).value - tax;
                System.out.println("You successfully sold a car and earned " + this.ownedCars.get(number).value + " American USD Dollars. You also paid the tax of " + tax + ".");
                this.ownedCars.remove(number);
                transactionCounter++;
            } else {
                System.out.println("This client is looking for a different car.");
            }
        } else {
            System.out.println("This client cannot afford your car.");
        }
    }
    public void inspectCar(int number) {
            if (this.ownedCars.get(number).isInspected) {
                System.out.println("This car was already inspected. Status: \n" + this.ownedCars.get(number).carCondition);
            } else if (this.ownedCars.get(number).carCondition == "Mint condition") {
                System.out.println("This car is in mint condition! Car value + 25%.");
                this.ownedCars.get(number).value = this.ownedCars.get(number).value + 0.25 * this.ownedCars.get(number).value;
                this.ownedCars.get(number).isInspected = true;
            } else {
                System.out.println("This car is suffering from: " + this.ownedCars.get(number).carCondition + " Value dropped by 10%.");
                this.ownedCars.get(number).value = this.ownedCars.get(number).value - 0.1 * this.ownedCars.get(number).value;
                System.out.println("You will have to get it fixed to get profit.");
                this.ownedCars.get(number).isInspected = true;
            }
        }
     public void setOwnedCars() {
        this.ownedCars = new ArrayList<>();
        }
    }


