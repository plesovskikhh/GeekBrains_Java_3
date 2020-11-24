package ru.GeekBrains.Java_3.lession_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Mass {
    public static void main(String[] args) {
        /**
         * 1. Написать метод, который меняет два элемента массива местами.
         * (массив может быть любого ссылочного типа);
         */
        Integer[] firstArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Source array: ");
        System.out.println(Arrays.toString(firstArray));
        changeElementsInArray(firstArray, 0, firstArray.length - 1);
        System.out.println("Replacement of the first element:");
        System.out.println(Arrays.toString(firstArray));
        changeElementsInArray(firstArray, 1, firstArray.length - 2);
        System.out.println("Replacement of the second element:");
        System.out.println(Arrays.toString(firstArray));


        /**
         * 2. Написать метод, который преобразует массив в ArrayList;
         */
        ArrayList<Integer> secondArrayList = arrayToArrayList(firstArray);
        System.out.println("Array to ArrayList: ");
        System.out.println(secondArrayList);

    }

        public static <T> void changeElementsInArray(T[] source, int firstElementIndex, int secondElementIndex) {
            if (source == null)
                throw new NullPointerException("The original array is not initialized");

            if (firstElementIndex < 0 || firstElementIndex > source.length - 1)
                throw new ArrayIndexOutOfBoundsException("The index of the first element is outside the array");

            if (secondElementIndex < 0 || secondElementIndex > source.length - 1)
                throw new ArrayIndexOutOfBoundsException("The index of the second element is outside the array");

            T temp = source[firstElementIndex];
            source[firstElementIndex] = source[secondElementIndex];
            source[secondElementIndex] = temp;
        }

        /**
         * 2. Написать метод, который преобразует массив в ArrayList;
         */

        public static <T> ArrayList<T> arrayToArrayList(T[] source) {
            if (source == null)
               throw new NullPointerException("The original array is not initialized");

            return new ArrayList<>(Arrays.asList(source));
       }
    }
