package by.epam.webdevelopment.arrays.parser.impl;

import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.parser.CustomArrayParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IntegerCustomArrayParserTest {
    CustomArrayParser parser;
    @BeforeClass
    public void setUp(){
        parser = new IntegerCustomArrayParser();
    }
    @Test
    public void testParseStringCorrectData() throws ProjectException {
        String validData = "1 5  9 3 -5  55";
        int[] expected = {1, 5, 9, 3, -5, 55};
        int[] actual = parser.parseString(validData);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testParseStringNullData() throws ProjectException {
        String nullData = null;
        int[] actual = parser.parseString(nullData);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testParseStringIncorrectData() throws ProjectException {
        String invalidData = "1 5  9.4 3 -5  55";
        int[] actual = parser.parseString(invalidData);
    }
}