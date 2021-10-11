package by.epam.lozovenko.firsttask.service.impl;

import by.epam.lozovenko.firsttask.creator.CustomArrayCreator;
import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.parser.impl.IntegerCustomArrayParser;
import by.epam.lozovenko.firsttask.reader.impl.CustomFileReaderImpl;
import by.epam.lozovenko.firsttask.entity.CustomArray;
import by.epam.lozovenko.firsttask.service.SearchService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class StreamSearchServiceTest {
    SearchService searchService;
    CustomArray testCustomArray;

    @BeforeClass
    public void setUp() {
        searchService = new StreamSearchService();
        //searchService = new CustomSearchService();
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        List<String> lines = fileReader.readLinesFromFile("data/testdata.txt");
        IntegerCustomArrayParser parser = new IntegerCustomArrayParser();
        int[] array = parser.parseStringToIntegerArray(lines.get(0)).orElse(new int[0]);
        testCustomArray = CustomArrayCreator.createCustomArray(array);
    }

    @Test
    public void testFindMaxValue() throws ProjectException {
        int expected = 21;
        int actual = searchService.findMaxValue(testCustomArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindMinValue() throws ProjectException {
        int expected = -66;
        int actual = searchService.findMinValue(testCustomArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAverageValue() throws ProjectException {
        double expected = -0.25f;
        double actual = searchService.findAverageValue(testCustomArray);
        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testPositiveValuesCount() throws ProjectException {
        long positivesExpected = 6;
        long positivesActual = searchService.positiveValuesCount(testCustomArray);
        assertEquals(positivesActual, positivesExpected);
    }

    @Test
    public void testNegativeValuesCount() throws ProjectException {
        long positivesExpected = 2;
        long positivesActual = searchService.negativeValuesCount(testCustomArray);
        assertEquals(positivesActual, positivesExpected);
    }

    @Test
    public void testSumValues() throws ProjectException {
        long expected = -2;
        long actual = searchService.sumValues(testCustomArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeValuesByCondition() throws ProjectException {
        CustomArray copyArray;
        CustomArray expectedCustomArray = new CustomArray(new int[]{-14, 16, 64, -33, 10, 6, 22, 64});

        copyArray = searchService.changeValuesByCondition(testCustomArray);

        assertEquals(copyArray, expectedCustomArray);
    }
}