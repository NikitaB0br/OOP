package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    private final DataProcessor<ItemsStatistic> dataProcessor = new DataProcessor<>();
    private final List<ItemsStatistic> productsAndPresents = new ArrayList<>(Arrays.asList(
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


    @DisplayName("Проверка фильтрации на ошибку")
    @Test
    void filterException() {
        assertThrows(CustomException.class, () -> dataProcessor.filterByPrice(4, 3, productsAndPresents));
    }

    @DisplayName("Проверка фильтрации")
    @Test
    void filterByMark() throws CustomException {
        List<ItemsStatistic> filteredList = dataProcessor.filterByPrice(10, 18, productsAndPresents);

        assertEquals(5, filteredList.size());
        assertEquals(11.0, filteredList.get(0).price);
        assertEquals(11.1, filteredList.get(1).price);
        assertEquals(12.1, filteredList.get(2).price);
        assertEquals(13.3, filteredList.get(3).price);
        assertEquals(15.0, filteredList.get(4).price);
        assertEquals(4, filteredList.get(0).id);
        assertEquals(7, filteredList.get(1).id);
        assertEquals(9, filteredList.get(2).id);
        assertEquals(2, filteredList.get(3).id);
        assertEquals(1, filteredList.get(4).id);
    }

    @DisplayName("Проверка поиска")
    @Test
    void findByMark() {

        Optional<ItemsStatistic> searchResultFalse = dataProcessor.findByPrice(7, productsAndPresents);
        Optional<ItemsStatistic> searchResultTrue = dataProcessor.findByPrice(23.0, productsAndPresents);
        Optional<ItemsStatistic> searchResultEmpty = dataProcessor.findByPrice(23.0, new ArrayList<>());

        assertFalse(searchResultEmpty.isPresent());
        assertFalse(searchResultFalse.isPresent());
        assertTrue(searchResultTrue.isPresent());
        assertEquals(6, searchResultTrue.get().id);
    }
}