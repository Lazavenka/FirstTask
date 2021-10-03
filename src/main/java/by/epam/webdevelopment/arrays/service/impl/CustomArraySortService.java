package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.service.SortService;

import java.util.Random;

public class CustomArraySortService implements SortService {
    @Override
    public void insertionSort(CustomArray customArray) throws ProjectException {
        for (int left = 0; left < customArray.getLength(); left++) {
            // Вытаскиваем значение элемента
            int value = customArray.getElement(left);
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < customArray.getElement(i)) {
                    customArray.setElement(customArray.getElement(i), i + 1);
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            customArray.setElement(value, i + 1);
        }
    }

    @Override
    public void selectionSort(CustomArray customArray) throws ProjectException {
        for (int left = 0; left < customArray.getLength(); left++) {
            int minInd = left;
            for (int i = left; i < customArray.getLength(); i++) {
                if (customArray.getElement(i) < customArray.getElement(minInd)) {
                    minInd = i;
                }
            }
            swap(customArray, left, minInd);
        }
    }

    @Override
    public void quickSort(CustomArray customArray) throws ProjectException {
        int low = 0;
        int high = customArray.getLength() - 1;
        quickSort(customArray, low, high);
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
