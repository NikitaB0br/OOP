package org.example;

public class Seller implements Printer {
    String name;
    public Seller(String name) {
        this.name = name;
    }

    @Override
    public void printInfo() {
        System.out.println("Продавец : " + this.name);
    }
}