package by.epam.webdevelopment.arrays.validator;

import by.epam.webdevelopment.arrays.exception.ProjectException;

public interface CustomArrayValidator {
    boolean validate(String string) throws ProjectException;
}
