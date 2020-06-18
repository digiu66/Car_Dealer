package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Client {

    String[] nameBase = new String[]{"Johnny", "Jacek", "Martin", "Diablo", "Tim", "Wojciech", "Darek", "Slavek", "Randall", "Bobby", "Grzesiek", "Sylvester", "Mati", "Przemek", "Piotrek", "Maciek", "Janek"};
    String name;
    String[] likedBrandBase = new String[]{"Honda", "FSO", "Daewoo", "Opel", "BMW", "Ford", "Toyota", "Audi", "Tesla", "Mercedes", "Chrysler", "Porsche"};
    String likedBrand1;
    String likedBrand2;
    double randomMoneyBudget = ThreadLocalRandom.current().nextInt(3000, 150000 + 1);
    Double money;

    ArrayList<Client> clients = new ArrayList<>();

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public Client() {
        this.name = getRandom(nameBase);
        this.likedBrand1 = getRandom(likedBrandBase);
        this.likedBrand2 = getRandom(likedBrandBase);
        while(likedBrand1 == likedBrand2) {
            this.likedBrand2 = getRandom(likedBrandBase);
        }
        this.money = randomMoneyBudget;
    }

    public ArrayList<Client> fillClientBase() {
        for(int i = 0; i < 5; i++) {
            clients.add(new Client());
        }
        return clients;
    }
    public void setClients() {
        this.fillClientBase();
    }

    public ArrayList<Client> rerollClients() {
        clients.clear();
        for(int i = 0; i < 5; i++) {
            clients.add(new Client());
        }
        return clients;
    }
    public String toString() {
        return "\nName: " + name + ", Likes: " + likedBrand1 + ", " + likedBrand2 + ", Budget: " + money;
    }
}
