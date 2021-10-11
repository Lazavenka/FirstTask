package by.epam.lozovenko.firsttask.service.impl;

import by.epam.lozovenko.firsttask.creator.CustomArrayCreator;
import by.epam.lozovenko.firsttask.entity.CustomArray;
import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.service.SortService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArraySortServiceTest {
    SortService sortService;
    CustomArray testCustomArray;

    @BeforeClass
    public void setUp() {
        sortService = new CustomArraySortService();
        testCustomArray = CustomArrayCreator.createCustomArray(new int[]{9, 6, 4, -5, 3, 4, 10, -2});
    }

    @Test
    public void testSelectionSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = CustomArrayCreator.createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.selectionSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }

    @Test
    public void testInsertionSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = CustomArrayCreator.createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.insertionSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }

    @Test
    public void testQuickSort() throws ProjectException {
        CustomArray actualCopy;
        CustomArray expected = CustomArrayCreator.createCustomArray(new int[]{-5, -2, 3, 4, 4, 6, 9, 10});

        actualCopy = sortService.quickSort(testCustomArray);

        assertEquals(actualCopy, expected);
    }
}