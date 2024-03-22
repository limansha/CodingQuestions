package com.ds.easyTips;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {
        Integer[] arr1 = { 5, 3, 9, 1, 7 };

        // Sort in descending order
        Arrays.sort(arr1, Comparator.reverseOrder());

        // Print the sorted array
        System.out.println(Arrays.toString(arr1));

        String[] arr = { "banana", "apple", "orange", "grape" };

        // Sort in descending order
        Arrays.sort(arr, Comparator.reverseOrder());

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
        // Sort in descending order based on last character
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                char lastChar1 = s1.charAt(s1.length() - 1);
                char lastChar2 = s2.charAt(s2.length() - 1);
                return Character.compare(lastChar2, lastChar1); // Compare in descending order
            }
        });

        // Print the sorted array
        System.out.println(Arrays.toString(arr));

        // Sort in descending order using lambda based on the last character
        Arrays.sort(arr,
                Comparator.comparing((String s) -> s.charAt(s.length() - 1)).reversed());

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
        // Sort in descending order using compare mtd based on the last character
        Arrays.sort(arr, (s1, s2) -> 
        Character.compare(s2.charAt(s2.length() - 1), s1.charAt(s1.length() - 1)));

        // Print the sorted array
        System.out.println(Arrays.toString(arr));

    }
}
