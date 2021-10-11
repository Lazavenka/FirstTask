package by.epam.lozovenko.firsttask.validator.impl;

import by.epam.lozovenko.firsttask.validator.CustomArrayValidator;

public class CustomIntegerArrayValidator implements CustomArrayValidator {

    private static final String INTEGER_ARRAY_PATTERN = "^-?\\d+(\\s+(-?\\d+))*$";

    @Override
    public boolean validate(String string) {
        return string != null && string.matches(INTEGER_ARRAY_PATTERN);
    }
}
