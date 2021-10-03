package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.service.SearchService;

public class CustomSearchService implements SearchService {
    @Override
    public int findMaxValue(CustomArray array) throws ProjectException {
        int maxValue = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            if (maxValue <= current){
                maxValue = current;
            }
        }
        return maxValue;
    }

    @Override
    public int findMinValue(CustomArray array) throws ProjectException {
        int minValue = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            if (minValue >= current){
                minValue = current;
            }
        }
        return minValue;
    }

    @Override
    public double findAverageValue(CustomArray array) throws ProjectException {
        double length = array.getLength();
        long sum = sumValues(array);
        return sum / length;
    }

    @Override
    public long positiveValuesCount(CustomArray array) throws ProjectException {
        int positiveCount = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            if (current >= 0){
                positiveCount++;
            }
        }
        return positiveCount;
    }

    @Override
    public long negativeValuesCount(CustomArray array) throws ProjectException {
        int negativeCount = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            if (current < 0){
                negativeCount++;
            }
        }
        return negativeCount;
    }

    @Override
    public long sumValues(CustomArray array) throws ProjectException {
        long sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            sum += current;
        }
        return sum;
    }

    @Override
    public void changeValuesByCondition(CustomArray array) throws ProjectException {
        for (int i = 0; i < array.getLength(); i++) {
            int element = array.getElement(i);
            int newValue;
            if (element % 2 == 0){
                newValue = element / 2;
            }else {
                newValue = element * 3 + 1;
            }
            array.setElement(newValue, i);
        }
    }
}
