package by.epam.webdevelopment.arrays.service;

import by.epam.webdevelopment.arrays.entity.CustomArray;

public interface SortService {
    void quickSort(CustomArray customArray);
    void shellSort(CustomArray customArray);
}
