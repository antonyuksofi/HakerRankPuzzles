package puzzles.dynamicprogramming.maxarraysum;

public class MaxArraySumDynamic {

    static long maxSubsetSum(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        if (arr.length == 2) {
            return getMaxOf2(arr[0], arr[1]);
        }

        long[] maxSums = new long[arr.length];
        maxSums[0] = arr[0];
        maxSums[1] = arr[1];
        maxSums[2] = getMaxOf3(arr[2], maxSums[0], maxSums[0] + arr[2]);

        long prevElementsMaxSum;
        for (int i = 3; i < arr.length; i++) {
            prevElementsMaxSum = getMaxOf2(maxSums[i - 2], maxSums[i - 3]);
            maxSums[i] += getMaxOf3(arr[i], prevElementsMaxSum, arr[i] + prevElementsMaxSum);
        }

        return getMaxOf2(maxSums[maxSums.length - 1], maxSums[maxSums.length - 2]);
    }

    private static long getMaxOf3(long a, long b, long c) {
        return getMaxOf2(a, getMaxOf2(b, c));
    }

    private static long getMaxOf2(long a, long b) {
        return a > b ? a : b;
    }
}
