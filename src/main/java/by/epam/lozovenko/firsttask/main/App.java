package by.epam.lozovenko.firsttask.main;

import by.epam.lozovenko.firsttask.reader.impl.CustomFileReaderImpl;
import by.epam.lozovenko.firsttask.creator.CustomArrayCreator;
import by.epam.lozovenko.firsttask.entity.CustomArray;
import by.epam.lozovenko.firsttask.exception.ProjectException;
import by.epam.lozovenko.firsttask.parser.CustomArrayParser;
import by.epam.lozovenko.firsttask.parser.impl.IntegerCustomArrayParser;
import by.epam.lozovenko.firsttask.reader.CustomFileReader;
import by.epam.lozovenko.firsttask.service.SearchService;
import by.epam.lozovenko.firsttask.service.impl.StreamSearchService;
import by.epam.lozovenko.firsttask.validator.CustomArrayValidator;
import by.epam.lozovenko.firsttask.validator.impl.CustomIntegerArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final String DEFAULT_FILE_PATH = "data/data.txt";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReaderImpl();
        CustomArrayValidator validator = new CustomIntegerArrayValidator();
        CustomArrayParser parser = new IntegerCustomArrayParser();
        List<String> lines = fileReader.readLinesFromFile(DEFAULT_FILE_PATH);
        List<CustomArray> arrays = lines.stream()
                .filter(validator::validate)
                .map(parser::parseStringToIntegerArray)
                .filter(Optional::isPresent)
                .map(Optional::get)
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
