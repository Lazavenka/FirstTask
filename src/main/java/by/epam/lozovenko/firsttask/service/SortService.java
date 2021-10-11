package by.epam.lozovenko.firsttask.service;

import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.entity.CustomArray;

public interface SortService {
    CustomArray insertionSort(CustomArray customArray) throws ProjectException;

    CustomArray selectionSort(CustomArray customArray) throws ProjectException;

    CustomArray quickSort(CustomArray customArray) throws ProjectException;
}
