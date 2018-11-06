package puzzles.sorting;

import java.util.Arrays;

public class MergeSortCountingInversions {
    private static long inversionsCounter;

    static long countInversions(int[] array) {
        inversionsCounter = 0;

        int[] result = mergeSortWithCounter(array);
        /*for (int item : result) {
            System.out.println(item);
        }*/

        return inversionsCounter;
    }

    static int[] mergeSortWithCounter(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] leftPart = mergeSortWithCounter(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] rightPart = mergeSortWithCounter(Arrays.copyOfRange(array, array.length / 2, array.length));
        return merge(leftPart, rightPart);
    }

    static int[] merge(int[] leftPart, int[] rightPart) {
        int[] result = new int[leftPart.length + rightPart.length];
        int leftArrayHead = 0;
        int rightArrayHead = 0;

        for (int i = 0; i < result.length; i++) {
            if (leftArrayHead >= leftPart.length) {
                result[i] = rightPart[rightArrayHead];
                rightArrayHead++;
            } else if (rightArrayHead >= rightPart.length) {
                result[i] = leftPart[leftArrayHead];
                leftArrayHead++;
            } else {
                if (rightPart[rightArrayHead] < leftPart[leftArrayHead]) {
                    result[i] = rightPart[rightArrayHead];
                    inversionsCounter += (rightArrayHead + leftPart.length) - i;
                    rightArrayHead++;
                } else {
                    result[i] = leftPart[leftArrayHead];
                    leftArrayHead++;
                }
            }
        }

        return result;
    }
}
