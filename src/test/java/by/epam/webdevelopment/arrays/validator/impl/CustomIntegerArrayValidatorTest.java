package by.epam.webdevelopment.arrays.validator.impl;

import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomIntegerArrayValidatorTest {
    CustomArrayValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new CustomIntegerArrayValidator();
    }

    @Test
    public void testValidateValidString() {
        String validData = "1 5 3   562 7 5";
        boolean actual = validator.validate(validData);
        assertTrue(actual);
    }

    @Test
    public void testValidateInvalidString() {
        String invalidData = "1 f 5 2 f 5 7";
        boolean actual = validator.validate(invalidData);
        assertFalse(actual);
    }

    @Test
    public void testValidateInvalidString2() {
        String invalidData = "1 5.5 5 2 33 5 7";
        boolean actual = validator.validate(invalidData);
        assertFalse(actual);
    }

    @Test
    public void testValidateNullData() {
        String nullData = null;
        boolean actual = validator.validate(nullData);
        assertFalse(actual);
    }

}