package by.epam.webdevelopment.arrays.entity;

import by.epam.webdevelopment.arrays.exception.ProjectException;

import java.util.Arrays;

public class CustomArray {
    private final int[] array;

    public CustomArray() {
        this.array = new int[10];
    }

    public CustomArray(int[] array) {
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public int[] getArray() {
        return array.clone();
    }

    public int getElement(int index) throws ProjectException {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new ProjectException("Index out of bounds!");
        }
    }

    public int getLength() {
        return array.length;
    }

    public void setElement(int value, int index) throws ProjectException {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            throw new ProjectException("Index out of bounds!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
