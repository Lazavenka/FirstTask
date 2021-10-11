package by.epam.webdevelopment.arrays.creator;

import by.epam.webdevelopment.arrays.entity.CustomArray;

public class CustomArrayCreator {
    public static CustomArray createCustomArray(int[] array) {
        return array != null ? new CustomArray(array) : new CustomArray();
    }
}
