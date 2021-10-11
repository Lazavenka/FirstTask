package by.epam.lozovenko.firsttask.creator;

import by.epam.lozovenko.firsttask.entity.CustomArray;

public class CustomArrayCreator {
    public static CustomArray createCustomArray(int[] array) {
        return array != null ? new CustomArray(array) : new CustomArray();
    }
}
