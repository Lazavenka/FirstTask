package by.epam.webdevelopment.arrays.parser;

import by.epam.webdevelopment.arrays.exception.ProjectException;

public interface CustomArrayParser {
    int[] parseString(String string) throws ProjectException;
}
