package by.epam.lozovenko.firsttask.service;

import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.entity.CustomArray;

public interface SearchService {
    int findMaxValue(CustomArray array) throws ProjectException;

    int findMinValue(CustomArray array) throws ProjectException;

    double findAverageValue(CustomArray array) throws ProjectException;

    long positiveValuesCount(CustomArray array) throws ProjectException;

    long negativeValuesCount(CustomArray array) throws ProjectException;

    long sumValues(CustomArray array) throws ProjectException;

    CustomArray changeValuesByCondition(CustomArray array) throws ProjectException; // if even - new value = old / 2, else - old * 3 + 1

}
