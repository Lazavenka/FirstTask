package by.epam.webdevelopment.arrays.service;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;

public interface SortService {
    CustomArray insertionSort(CustomArray customArray) throws ProjectException;

    CustomArray selectionSort(CustomArray customArray) throws ProjectException;

    CustomArray quickSort(CustomArray customArray) throws ProjectException;
}
