package org.example;

public class Product extends ItemsStatistic {

    public Product(int id, double amount, double price ) {
        super(id, amount, price);
    }

    public void printInfo() {
        System.out.println("Товар : " + this.id + " Количество : " + this.amount + " Цена : " + this.price + " Стоимость: " + this.amount * this.price);
    }
}
