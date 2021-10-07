package by.epam.webdevelopment.arrays.main;

import by.epam.webdevelopment.arrays.creator.CustomArrayCreator;
import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.parser.CustomArrayParser;
import by.epam.webdevelopment.arrays.parser.impl.IntegerCustomArrayParser;
import by.epam.webdevelopment.arrays.reader.CustomFileReader;
import by.epam.webdevelopment.arrays.reader.impl.CustomFileReaderImpl;
import by.epam.webdevelopment.arrays.service.SearchService;
import by.epam.webdevelopment.arrays.service.impl.StreamSearchService;
import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import by.epam.webdevelopment.arrays.validator.impl.CustomIntegerArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final String FILE_PATH = "data/data.txt";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReaderImpl();
        CustomArrayValidator validator = new CustomIntegerArrayValidator();
        CustomArrayParser parser = new IntegerCustomArrayParser();
        List<String> lines = fileReader.readLinesFromFile(FILE_PATH);
        List<CustomArray> arrays = lines.stream()
                .filter(validator::validate)
                .map(string -> {
                    try {
                        return parser.parseString(string);
                    } catch (ProjectException e) {
                        logger.error("Parsing error: " + e);
                    }
                    return null;
                })
                .map(CustomArrayCreator::createCustomArray)
                .collect(Collectors.toList());
        if (!arrays.isEmpty()) {
            SearchService searchService = new StreamSearchService();
            for (CustomArray array : arrays) {
                logger.log(Level.INFO, array);
                try {
                    int maxValue = searchService.findMaxValue(array);
                    int minValue = searchService.findMinValue(array);
                    double averageValue = searchService.findAverageValue(array);
                    long negativeCount = searchService.negativeValuesCount(array);
                    long positiveCount = searchService.positiveValuesCount(array);
                    long sum = searchService.sumValues(array);
                    CustomArray changedArray = searchService.changeValuesByCondition(array);
                    logger.printf(Level.INFO, "Min value = %d, max value = %d, average value = %.4f, " +
                                    "negative numbers = %d, positive numbers = %d, sum = %d", maxValue, minValue, averageValue,
                            negativeCount, positiveCount, sum);
                    logger.printf(Level.INFO, "After change values: %s", changedArray);
                } catch (ProjectException e) {
                    logger.error("Parsing error: " + e);
                }
            }
        }
    }
}
