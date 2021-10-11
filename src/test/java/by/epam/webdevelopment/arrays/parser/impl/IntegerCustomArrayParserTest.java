package by.epam.webdevelopment.arrays.parser.impl;

import by.epam.webdevelopment.arrays.parser.CustomArrayParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class IntegerCustomArrayParserTest {
    CustomArrayParser parser;

    @BeforeClass
    public void setUp() {
        parser = new IntegerCustomArrayParser();
    }

    @Test
    public void testParseStringCorrectData() {
        String validData = "1 5  9 3 -5  55";
        int[] expected = {1, 5, 9, 3, -5, 55};
        Optional<int[]> actualOptional = parser.parseStringToIntegerArray(validData);
        int[] actual = actualOptional.orElseThrow();

        assertEquals(actual, expected);
    }

    @Test
    public void testParseStringNullData() {
        String nullData = null;
        Optional<int[]> actual = parser.parseStringToIntegerArray(nullData);
        Optional<int[]> expected = Optional.empty();

        assertEquals(actual, expected);
    }

    @Test
    public void testParseStringIncorrectData() {
        String invalidData = "1 5  9.4 3 -5  55";
        Optional<int[]> actual = parser.parseStringToIntegerArray(invalidData);
        Optional<int[]> expected = Optional.empty();

        assertEquals(actual, expected);
    }
}