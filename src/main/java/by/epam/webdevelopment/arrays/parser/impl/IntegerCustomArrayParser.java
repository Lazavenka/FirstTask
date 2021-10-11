package by.epam.webdevelopment.arrays.parser.impl;

import by.epam.webdevelopment.arrays.parser.CustomArrayParser;
import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import by.epam.webdevelopment.arrays.validator.impl.CustomIntegerArrayValidator;

import java.util.Arrays;
import java.util.Optional;

public class IntegerCustomArrayParser implements CustomArrayParser {
    private static final String REGEX_DELIMITER = "\\s+";

    @Override
    public Optional<int[]> parseStringToIntegerArray(String string) {
        CustomArrayValidator validator = new CustomIntegerArrayValidator();
        Optional<int[]> parsedOptional;
        if (validator.validate(string)) {
            parsedOptional = Optional.of(Arrays.stream(string.split(REGEX_DELIMITER))
                    .mapToInt(Integer::parseInt).toArray());
        } else {
            parsedOptional = Optional.empty();
        }
        return parsedOptional;
    }
}
