package org.example;

import java.util.List;
import java.util.Optional;

public class DataProcessor<T extends ItemsStatistic> {

    public List<T> filterByPrice(double min, double max, List<T> list) throws CustomException {
        if (max < min ) throw new CustomException("максимальное значение меньше минимального.");
        return list.stream()
                .filter(item -> item.price >= min && item.price < max)
                .sorted((a, b) -> {
                    return Double.compare(a.price, b.price);
                })
                .limit(5)
                .toList();

    }

    public Optional<T> findByPrice(double price, List<T> list) {

        return list.stream()
                .filter(item -> item.price == price).findFirst();

    }
}