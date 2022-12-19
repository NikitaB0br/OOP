package org.example;

public class Present extends ItemsStatistic {
    public Present(int id, double amount) {
        super(id, amount, 0);
    }

    @Override
    public void printInfo() {
        System.out.println("Подарок : " + this.id + " Количество : " + this.amount);
    }
}
