package by.epam.lozovenko.firsttask.parser.impl;

import by.epam.lozovenko.firsttask.validator.CustomArrayValidator;
import by.epam.lozovenko.firsttask.validator.impl.CustomIntegerArrayValidator;
import by.epam.lozovenko.firsttask.parser.CustomArrayParser;

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
