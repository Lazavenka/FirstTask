package by.epam.webdevelopment.arrays.service.impl;

import by.epam.webdevelopment.arrays.creator.CustomArrayCreator;
import by.epam.webdevelopment.arrays.entity.CustomArray;
import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamSearchService implements SearchService {
    private static final Logger logger = LogManager.getLogger(StreamSearchService.class);

    @Override
    public int findMaxValue(CustomArray array) {
        IntStream copyArrayStream = IntStream.of(array.getArray());
        OptionalInt optMax = copyArrayStream.max();
        int result = 0;
        if (optMax.isPresent()) {
            result = optMax.getAsInt();
        } else {
            logger.error("Max value not found. Returned \"0\"!");
        }
        return result;
    }

    @Override
    public int findMinValue(CustomArray array) {
        IntStream copyArrayStream = IntStream.of(array.getArray());
        OptionalInt optMin = copyArrayStream.min();
        int result = 0;
        if (optMin.isPresent()) {
            result = optMin.getAsInt();
        } else {
            logger.error("Min value not found. Returned \"0\"!");
        }
        return result;
    }

    @Override
    public double findAverageValue(CustomArray array) {
        return IntStream.of(array.getArray()).average().orElse(0);
    }

    @Override
    public long positiveValuesCount(CustomArray array) {
        IntStream copyArrayStream = IntStream.of(array.getArray());
        return copyArrayStream.filter(i -> i >= 0).count();
    }

    @Override
    public long negativeValuesCount(CustomArray array) {
        IntStream copyArrayStream = IntStream.of(array.getArray());
        return copyArrayStream.filter(i -> i < 0).count();
    }

    @Override
    public long sumValues(CustomArray array) {
        IntStream copyArrayStream = IntStream.of(array.getArray());
        return copyArrayStream.sum();
    }

    @Override
    public CustomArray changeValuesByCondition(CustomArray array) {
        CustomArray copyArray = CustomArrayCreator.createCustomArray(array.getArray());
        IntStream.range(0, array.getLength())
                .forEach(index -> {
                    try {
                        int element = copyArray.getElement(index);
                        int newValue;
                        if (element % 2 == 0) {
                            newValue = element / 2;
                        } else {
                            newValue = element * 3 + 1;
                        }
                        copyArray.setElement(newValue, index);
                    } catch (ProjectException e) {
                        logger.error("Index out of bound: " + e);
                    }
                });
        return copyArray;
    }
}
