package puzzles.greedyalgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array of integers, find and print the minimum absolute difference between any two elements in the array.
 */
public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        arr = Arrays.stream(arr)
                .sorted()
                .toArray();

        int minDif = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < minDif) {
                minDif = Math.abs(arr[i] - arr[i + 1]);
            }
        }
        return minDif;
    }
}
