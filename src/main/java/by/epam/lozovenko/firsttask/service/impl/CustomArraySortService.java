package by.epam.lozovenko.firsttask.service.impl;

import by.epam.lozovenko.firsttask.creator.CustomArrayCreator;
import by.epam.lozovenko.firsttask.entity.CustomArray;
import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.service.SortService;

public class CustomArraySortService implements SortService {
    @Override
    public CustomArray insertionSort(CustomArray customArray) throws ProjectException {
        CustomArray copyArray = CustomArrayCreator.createCustomArray(customArray.getArray());
        int length = copyArray.getLength();
        for (int i = 1; i < length; i++) {
            int key = copyArray.getElement(i);
            int j = i - 1;
            while (j >= 0 && copyArray.getElement(j) > key) {
                copyArray.setElement(copyArray.getElement(j), j + 1);
                j = j - 1;
            }
            copyArray.setElement(key, j + 1);
        }
        return copyArray;
    }

    @Override
    public CustomArray selectionSort(CustomArray customArray) throws ProjectException {
        CustomArray copyArray = CustomArrayCreator.createCustomArray(customArray.getArray());
        for (int left = 0; left < copyArray.getLength(); left++) {
            int minInd = left;
            for (int i = left; i < copyArray.getLength(); i++) {
                if (copyArray.getElement(i) < copyArray.getElement(minInd)) {
                    minInd = i;
                }
            }
            swap(copyArray, left, minInd);
        }
        return copyArray;
    }

    @Override
    public CustomArray quickSort(CustomArray customArray) throws ProjectException {
        CustomArray copyArray = CustomArrayCreator.createCustomArray(customArray.getArray());
        int low = 0;
        int high = copyArray.getLength() - 1;
        quickSort(copyArray, low, high);
        return copyArray;
    }

    private int partition(CustomArray array, int low, int high) throws ProjectException {
        int pivot = array.getElement(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array.getElement(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    private void quickSort(CustomArray array, int low, int high) throws ProjectException {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private void swap(CustomArray array, int a, int b) throws ProjectException {
        int temp = array.getElement(a);
        array.setElement(array.getElement(b), a);
        array.setElement(temp, b);
    }
}
