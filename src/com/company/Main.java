package com.company;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        Dealership you = new Dealership();
        you.setOwnedCars();
        System.out.println("Hello " + name + "!" + "\n" + "These are the first cars to buy. You currently have " + you.cash + " american usd dollars.");
        System.out.println("Choose a car to buy:");


        Garage garage = new Garage();
        garage.setCars();
        System.out.println(garage.cars);

        int car = input.nextInt();
            switch (car) {
                case 1: {
                     {
                        you.buyCar(garage, 0);
                        break;
                    }
                }
                case 2: {
                    you.buyCar(garage, 1);
                        break;
                }
                case 3: {
                    you.buyCar(garage, 2);
                        break;
                    }
                case 4: {
                    you.buyCar(garage, 3);
                        break;
                    }
                case 5: {
                    you.buyCar(garage, 4);
                        break;
                    }
                default:
                    System.out.println("You cannot afford this car.");
            }
            System.out.println("Your currently owned cars: ");
            System.out.println(you.ownedCars);
            System.out.print(you.cash + "\n");

            System.out.println(garage.cars);
        }
    }
