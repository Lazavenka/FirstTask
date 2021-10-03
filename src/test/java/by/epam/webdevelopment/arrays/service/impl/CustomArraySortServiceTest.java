package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArraySortServiceTest {
    SortService sortService;
    CustomArray testCustomArray;
    @BeforeClass
    public void setUp(){
        sortService = new CustomArraySortService();
        testCustomArray = new CustomArray(new int[]{9, 6, 4, -5, 3, 4, 10, -2});
    }
    @Test
    public void testSelectionSort() throws ProjectException {
        CustomArray actualCopy = new CustomArray(testCustomArray.getCopyArray());
        CustomArray expected = new CustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        sortService.selectionSort(actualCopy);

        assertEquals(actualCopy, expected);
    }

    @Test
    public void testInsertionSort() throws ProjectException {
        CustomArray actualCopy = new CustomArray(testCustomArray.getCopyArray());
        CustomArray expected = new CustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        sortService.insertionSort(actualCopy);

        assertEquals(actualCopy, expected);
    }
    @Test
    public void testQuickSort() throws ProjectException {
        CustomArray actualCopy = new CustomArray(testCustomArray.getCopyArray());
        CustomArray expected = new CustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        sortService.quickSort(actualCopy);

        assertEquals(actualCopy, expected);
    }
}