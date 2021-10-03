package by.epam.webdevelopment.arrays.validator.impl;

import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomIntegerArrayValidator implements CustomArrayValidator {
    private static final Logger logger = LogManager.getLogger(CustomIntegerArrayValidator.class);

    private static final String VALID_PATTERN = "^-?\\d+(\\s+(-?\\d+))*$";
    @Override
    public boolean validate(String string) throws ProjectException {
        if (string == null){
            throw new ProjectException("Input string is null!");
        }
        boolean result = string.matches(VALID_PATTERN);
        logger.log(Level.INFO, "Line \""+ string+"\": valid = " + result);
        return result;
    }
}
