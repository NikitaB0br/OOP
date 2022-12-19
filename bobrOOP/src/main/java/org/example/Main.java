package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<ItemsStatistic> productsAndPresents = new ArrayList<>(Arrays.asList(
                new Product(1, 1.0, 15.0),
                new Product(2, 2.3, 13.3),
                new Product(3, 4.0, 18.1),
                new Product(4, 0.1, 11.0),
                new Product(5, 5.5, 67.0),
                new Product(6, 10.0, 23.0),
                new Product(7, 213.0, 11.1),
                new Product(8, 2.0, 18.1),
                new Product(9, 3.4, 12.1),
                new Product(10, 0.1, 23.3),
                new Present(4, 2),
                new Present(5, 12),
                new Present(6, 3)
        ));

        DataProcessor<ItemsStatistic> dataProcessor = new DataProcessor<>();

        try {
            List<ItemsStatistic> filterRes = dataProcessor.filterByPrice(10, 18, productsAndPresents);
            System.out.println("Фильтрация товаров:");
            filterRes.forEach(ItemsStatistic::printInfo);

        } catch (CustomException e) {
            System.out.println("Ошибка при фильтрации, " + e.getMessage());
        }

        Optional<ItemsStatistic> searchRes = dataProcessor.findByPrice(23.3, productsAndPresents);
        System.out.println("Поиск товара:");
        searchRes.ifPresent(ItemsStatistic::printInfo);
        if (searchRes.isEmpty()) {
            System.out.println("Ничего не найдено");
        }

        System.out.println("---------------------------------------------------------");

        List<Seller> sellers = new ArrayList<>(Arrays.asList(new Seller("Олег"),
                new Seller("Андрей"),
                new Seller("Ольга"))
        );

        int length = productsAndPresents.size() + sellers.size();

        List<Printer> allItems = new ArrayList<>(length);
        allItems.addAll(productsAndPresents);
        allItems.addAll(sellers);

        for (Printer item :
                allItems) {
            item.printInfo();
        }

        System.out.println("--------------------");
        Utils.printStatistic(productsAndPresents);


    }
}