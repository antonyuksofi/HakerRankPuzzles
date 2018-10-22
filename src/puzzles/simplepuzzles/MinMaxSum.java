package puzzles.simplepuzzles;

import java.util.Arrays;

public class MinMaxSum {

    static long[] miniMaxSum(int[] arr) {
        long sum = 0;

        for (int a : arr) {
            sum += a;
        }

        long sumWithoutMax = sum - Arrays.stream(arr).max().getAsInt();

        long sumWithoutMin = sum - Arrays.stream(arr).min().getAsInt();

        return new long[] {sumWithoutMax, sumWithoutMin};
    }
}
