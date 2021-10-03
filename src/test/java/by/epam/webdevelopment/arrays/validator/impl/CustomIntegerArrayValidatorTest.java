package by.epam.webdevelopment.arrays.validator.impl;

import by.epam.webdevelopment.arrays.exception.ProjectException;
import by.epam.webdevelopment.arrays.validator.CustomArrayValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomIntegerArrayValidatorTest {
    CustomArrayValidator validator;

    @BeforeClass
    public void setUp(){
        validator = new CustomIntegerArrayValidator();
    }
    @Test
    public void testValidate_validString() throws ProjectException{
        String validData = "1 5 3   562 7 5";
        boolean actual = validator.validate(validData);
        assertTrue(actual);
    }
    @Test()
    public void testValidate_invalidString() throws ProjectException{
        String invalidData = "1 f 5 2 f 5 7";
        boolean actual = validator.validate(invalidData);
        assertFalse(actual);
    }
    @Test()
    public void testValidate_invalidString2() throws ProjectException{
        String invalidData = "1 5.5 5 2 33 5 7";
        boolean actual = validator.validate(invalidData);
        assertFalse(actual);
    }
    @Test(expectedExceptions = ProjectException.class)
    public void testValidate_throwException() throws ProjectException{
        String nullData = null;
        validator.validate(nullData);
    }

}