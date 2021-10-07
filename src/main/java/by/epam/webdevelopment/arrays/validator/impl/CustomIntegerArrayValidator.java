package by.epam.webdevelopment.arrays.validator.impl;

import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;

public class CustomIntegerArrayValidator implements CustomArrayValidator {

    private static final String VALID_PATTERN = "^-?\\d+(\\s+(-?\\d+))*$";
    @Override
    public boolean validate(String string) {
        return string != null && string.matches(VALID_PATTERN);
    }
}
