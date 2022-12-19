package org.example;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void printStatistic(List<ItemsStatistic> items) {
        double maxprice = 0;
        double minprice = 10000000;
        int maxpriceid = 110;
        int minpriceid = 110;
        int n = items.size();
        double[] sum = new double[n];
        int expensiveproduct = 0;
        int inexpensiveproduct = 0;
        int largestamount = 0;
        int smallamount = 1000000;
        int expensivepurchase = 0;
        int inexpensivepurchase = 0;
        double summa = 0;
        double sumcount = 0;


        for (int i = 0; i < items.size(); i++) {

            if (maxprice < items.get(i).price) {
                maxprice = items.get(i).price;
                maxpriceid = i + 1;
            }
            if (minprice > items.get(i).price) {
                minprice = items.get(i).price;
                minpriceid = i + 1;
            }
            sum[i] = items.get(i).price * items.get(i).amount;

        }

        double minpurchase = 1000000;
        int minpurchaseid = 110;
        for (int i = 0; i < sum.length; i++)
        {
            if (minpurchase > sum[i])
            {
                minpurchase = sum[i];
                minpurchaseid = i + 1;
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (items.get(i).price > expensiveproduct)
            {
                expensiveproduct = i + 1;
            }
            if (items.get(i).price < inexpensiveproduct)
            {
                inexpensiveproduct = i + 1;
            }
            if (items.get(i).amount > largestamount)
            {
                largestamount = i + 1;
            }
            if (items.get(i).amount < smallamount)
            {
                smallamount = i + 1;
            }
            if (items.get(i).amount > expensivepurchase)
            {
                expensivepurchase = i + 1;
            }
            if (items.get(i).amount < inexpensivepurchase)
            {
                inexpensivepurchase = i + 1;
            }
            summa += sum[i];
            sumcount += items.get(i).amount;

        }

        System.out.println("Самый дорогой товар: " + maxpriceid);
        System.out.println("Самый дешёвый товар: " + minpriceid);
        System.out.println("Наибольшее кол-во: " + largestamount);
        System.out.println("Наименьшее кол-во: " + smallamount);
        System.out.println("Самая дорогая покупка: " + expensivepurchase);
        System.out.println("Самая дешёвая покупка: " + minpurchaseid);
        System.out.println("Сумма покупок: " + summa);
        System.out.println("Сумма кол-ва: " + sumcount);
        System.out.println("--------------------");
    }
}
