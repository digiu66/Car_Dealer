package com.company;


import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static int menu() {
        System.out.println("This is the main lodge. Here you can choose your further actions.");
        System.out.println("1. Browse cars to buy.");
        System.out.println("2. Check stats.");
        System.out.println("3. Inspect your cars.");
        System.out.println("4. Reroll offers (5000$).");
        System.out.println("5. Sell cars.");
        System.out.println("6. Repair cars.");

        Scanner inputChoice = new Scanner(System.in);
        int w = inputChoice.nextInt();

        return w;
    }


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        Dealership you = new Dealership();
        you.setOwnedCars();
        System.out.println("Hello " + name + "!" + "\n" + "Welcome to Car Dealer Sim." + "\n" + "You have " + you.cash + " American USD Dollars to start with.");


        Garage garage = new Garage();
        garage.setCars();


        int choice = menu();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println("These are cars available to buy:");
                    System.out.println("Choose a number (1-5) to pick your car.");
                    System.out.println("Your cash: " + you.cash);
                    System.out.println(garage.cars);
                    int car = input.nextInt();
                    switch (car) {
                        case 1:
                            you.buyCar(garage, 0);
                            break;

                        case 2:
                            you.buyCar(garage, 1);
                            break;

                        case 3:
                            you.buyCar(garage, 2);
                            break;

                        case 4:
                            you.buyCar(garage, 3);
                            break;

                        case 5:
                            you.buyCar(garage, 4);
                            break;

                        default:
                            System.out.println("Choose a number in range. (1-5)");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Your current cash: " + you.cash);
                    System.out.println("Your cars: " + you.ownedCars);
                    break;
                case 3:
                    if (you.ownedCars.size() == 0) {
                        System.out.println("You currently have no cars.");
                        break;
                    } else {
                        System.out.println("Choose a car to inspect:");
                        System.out.println(you.ownedCars);
                        int carToInspect = input.nextInt();
                        switch (carToInspect) {
                            case 1:
                                you.inspectCar(0);
                                break;
                            case 2:
                                you.inspectCar(1);
                                break;
                            case 3:
                                you.inspectCar(2);
                                break;
                            case 4:
                                you.inspectCar(3);
                                break;
                            case 5:
                                you.inspectCar(4);
                                break;
                            default:
                                System.out.println("Choose one of your cars (1-5).");
                                break;
                        }
                    }
                    break;
                case 4:
                    if (you.cash < 5000.0) {
                        System.out.println("You cannot afford checking new offers.");
                    } else {
                        you.cash = you.cash - 5000.0;
                        garage.rerollCars();
                        System.out.println("New offers appeared, check available cars.");
                    }
                    break;
                case 5:
                    if (you.ownedCars.size() == 0) {
                        System.out.println("You currently have no cars.");
                    } else {
                        System.out.println("Choose a car to sell (1-5): ");
                        System.out.println(you.ownedCars);
                        int sellNumber = input.nextInt();
                        switch (sellNumber) {
                            case 1:
                                you.sellCar(0);
                                break;
                            case 2:
                                you.sellCar(1);
                                break;
                            case 3:
                                you.sellCar(2);
                                break;
                            case 4:
                                you.sellCar(3);
                                break;
                            case 5:
                                you.sellCar(4);
                                break;
                            default:
                                System.out.println("Choose a car in range (1-5).");
                                break;
                        }
                    }
                    break;
                case 6:
                    if (you.ownedCars.size() == 0) {
                        System.out.println("You currently have no cars.");
                    } else {
                        System.out.println("Choose the mechanic:");
                        System.out.println("1. Jurij - base price: 1500$, takes additional money depending on the condition, has a low chance of breaking your car even more.");
                        System.out.println("2. Andrzej - base price: 5000$, takes additional money depending on the condition, adds 10% more to your car's value.");
                        System.out.println("3. Johnson - best in town, base price: 8000$, takes additional money depending on the condition, adds 18% more to your car's value.");
                        int mechanic = input.nextInt();
                        switch (mechanic) {
                            case 1:
                                System.out.println("You chose Jurij - the cheapest option.");
                                System.out.println("Choose the car to repair: ");
                                System.out.println(you.ownedCars);
                                int cheapCarRepairs = input.nextInt();
                                switch (cheapCarRepairs) {
                                    case 1:
                                        you.ownedCars.get(0).cheapRepairs(you);
                                        break;
                                    case 2:
                                        you.ownedCars.get(1).cheapRepairs(you);
                                        break;
                                    case 3:
                                        you.ownedCars.get(2).cheapRepairs(you);
                                        break;
                                    case 4:
                                        you.ownedCars.get(3).cheapRepairs(you);
                                        break;
                                    case 5:
                                        you.ownedCars.get(4).cheapRepairs(you);
                                        break;
                                    default:
                                        System.out.println("Choose a car in range (1-5).");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("You chose Andrzej - the standard option.");
                                System.out.println("Choose a car to repair: ");
                                System.out.println(you.ownedCars);
                                int standardCarRepairs = input.nextInt();
                                switch (standardCarRepairs) {
                                    case 1:
                                        you.ownedCars.get(0).standardRepairs(you);
                                        break;
                                    case 2:
                                        you.ownedCars.get(1).standardRepairs(you);
                                        break;
                                    case 3:
                                        you.ownedCars.get(2).standardRepairs(you);
                                        break;
                                    case 4:
                                        you.ownedCars.get(3).standardRepairs(you);
                                        break;
                                    case 5:
                                        you.ownedCars.get(5).standardRepairs(you);
                                        break;
                                    default:
                                        System.out.println("Choose a car in range (1-5).");
                                }
                                break;
                            case 3:
                                System.out.println("You chose Johnson - the deluxe option.");
                                System.out.println("Choose a car to repair: ");
                                System.out.println(you.ownedCars);
                                int deluxeCarRepairs = input.nextInt();
                                switch (deluxeCarRepairs) {
                                    case 1:
                                        you.ownedCars.get(0).deluxeRepairs(you);
                                        break;
                                    case 2:
                                        you.ownedCars.get(1).deluxeRepairs(you);
                                        break;
                                    case 3:
                                        you.ownedCars.get(2).deluxeRepairs(you);
                                        break;
                                    case 4:
                                        you.ownedCars.get(3).deluxeRepairs(you);
                                        break;
                                    case 5:
                                        you.ownedCars.get(4).deluxeRepairs(you);
                                        break;
                                    default:
                                        System.out.println("Choose a car in range (1-5).");
                                }
                                break;
                            default:
                                System.out.println("Choose a mechanic in range. (1-3)");
                        }

                    }
            }
            System.out.println("\nPress enter to continue...");
            System.in.read();
            choice = menu();
        }
    }
}

