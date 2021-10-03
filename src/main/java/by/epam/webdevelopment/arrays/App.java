package by.epam.webdevelopment.arrays;

import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.parser.CustomArrayParser;
import by.epam.webdevelopment.arrays.parser.impl.CustomIntegerCustomArrayParser;
import by.epam.webdevelopment.arrays.reader.CustomFileReader;
import by.epam.webdevelopment.arrays.service.SearchService;
import by.epam.webdevelopment.arrays.service.impl.StreamSearchService;
import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import by.epam.webdevelopment.arrays.validator.impl.CustomIntegerArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final String FILE_PATH = "src/main/resources/data.txt";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReader();
        CustomArrayValidator validator = new CustomIntegerArrayValidator();
        CustomArrayParser parser = new CustomIntegerCustomArrayParser();
        List<String> lines = fileReader.readLinesFromFile(FILE_PATH);
        List<CustomArray> arrays = lines.stream()
                .filter(line -> {
                    try {
                        return validator.validate(line);
                    } catch (ProjectException e) {
                        logger.error("Validation error: " + e);
                    }
                    return false;
                })
                .map(line -> {
                    try {
                        return new CustomArray(parser.parseString(line));
                    } catch (ProjectException e) {
                        logger.error("Parsing error: " + e);
                    }
                    return null;
                })
                .collect(Collectors.toList());
        arrays.forEach(array -> logger.log(Level.INFO, array));
        SearchService searchService = new StreamSearchService();
        arrays.forEach(searchService::changeValuesByCondition);
        logger.log(Level.INFO, "Change values:");
        arrays.forEach(array -> logger.log(Level.INFO, array));

    }
}
