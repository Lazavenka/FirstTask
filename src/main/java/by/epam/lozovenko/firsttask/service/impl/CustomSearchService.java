package by.epam.lozovenko.firsttask.service.impl;

import by.epam.lozovenko.firsttask.creator.CustomArrayCreator;
import by.epam.lozovenko.firsttask.entity.CustomArray;
import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.service.SearchService;

public class CustomSearchService implements SearchService {
    @Override
    public int findMaxValue(CustomArray array) throws ProjectException {
        int maxValue = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            int current = array.getElement(i);
            if (maxValue <= current) {
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
            if (minValue >= current) {
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
            if (current >= 0) {
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
            if (current < 0) {
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
    public CustomArray changeValuesByCondition(CustomArray array) throws ProjectException {
        CustomArray copyArray = CustomArrayCreator.createCustomArray(array.getArray());
        for (int i = 0; i < copyArray.getLength(); i++) {
            int element = copyArray.getElement(i);
            int newValue;
            if (element % 2 == 0) {
                newValue = element / 2;
            } else {
                newValue = element * 3 + 1;
            }
            copyArray.setElement(newValue, i);
        }
        return copyArray;
    }
}
