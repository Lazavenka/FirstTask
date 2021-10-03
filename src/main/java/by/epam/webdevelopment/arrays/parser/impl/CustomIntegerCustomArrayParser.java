package by.epam.webdevelopment.arrays.parser.impl;

import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.parser.CustomArrayParser;

public class CustomIntegerCustomArrayParser implements CustomArrayParser {
    private static final String REGEX_DELIMITER = "\\s+";
    @Override
    public int[] parseString(String string) throws ProjectException {
        if (string==null) {
            throw new ProjectException("Input string is null!");
        }
        String[] splitValues = string.split(REGEX_DELIMITER);
        int[] array = new int[splitValues.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(splitValues[i]);
        }
        return array;
    }
}
