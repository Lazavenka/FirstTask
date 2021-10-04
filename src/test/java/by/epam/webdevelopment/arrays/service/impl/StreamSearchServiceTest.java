package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.parser.impl.IntegerCustomArrayParser;
import by.epam.webdevelopment.arrays.reader.CustomFileReader;
import by.epam.webdevelopment.arrays.service.SearchService;
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
        CustomFileReader fileReader = new CustomFileReader();
        List<String> lines = fileReader.readLinesFromFile("src/main/resources/data/testdata.txt");
        IntegerCustomArrayParser parser = new IntegerCustomArrayParser();
        try {
            testCustomArray = new CustomArray(parser.parseString(lines.get(0)));
        } catch (ProjectException e) {
            e.printStackTrace();
        }
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
        CustomArray copyArray = new CustomArray(testCustomArray.getCopyArray());
        CustomArray expectedCustomArray = new CustomArray(new int[]{-14, 16, 64, -33, 10, 6, 22, 64});

        searchService.changeValuesByCondition(copyArray);

        assertEquals(copyArray, expectedCustomArray);
    }
}