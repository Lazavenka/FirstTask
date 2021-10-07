package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.epam.webdevelopment.arrays.creator.CustomArrayCreator.createCustomArray;
import static org.testng.Assert.*;

public class CustomArraySortServiceTest {
    SortService sortService;
    CustomArray testCustomArray;
    @BeforeClass
    public void setUp(){
        sortService = new CustomArraySortService();
        testCustomArray = createCustomArray(new int[]{9, 6, 4, -5, 3, 4, 10, -2});
    }
    @Test
    public void testSelectionSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.selectionSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }

    @Test
    public void testInsertionSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.insertionSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }
    @Test
    public void testQuickSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.quickSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }
}