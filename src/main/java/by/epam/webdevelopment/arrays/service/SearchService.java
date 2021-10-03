package by.epam.webdevelopment.arrays.service;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;

public interface SearchService{
    int findMaxValue(CustomArray array);
    int findMinValue(CustomArray array);
    double findAverageValue(CustomArray array);
    long positiveValuesCount(CustomArray array);
    long negativeValuesCount(CustomArray array);
    long sumValues(CustomArray array);
    void changeValuesByCondition(CustomArray array); // if even - new value = old / 2, else - old * 3 + 1

}
