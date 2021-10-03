package by.epam.webdevelopment.arrays.service;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;

public interface SortService {
    void insertionSort(CustomArray customArray) throws ProjectException;
    void selectionSort(CustomArray customArray) throws ProjectException;
    void quickSort(CustomArray customArray) throws ProjectException;
}
