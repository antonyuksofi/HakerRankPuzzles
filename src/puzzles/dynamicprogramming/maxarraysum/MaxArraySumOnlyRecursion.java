package puzzles.dynamicprogramming.maxarraysum;

import java.util.ArrayList;

public class MaxArraySumOnlyRecursion {

    static long maxSubsetSum(int[] arr) {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> currentSet = new ArrayList<>();
            currentSet.add(arr[i]);
            enrichSetAndAddToList(currentSet, i, arr, sets);
        }

        return getMaxSum(sets);
    }

    static void enrichSetAndAddToList(ArrayList<Integer> currentSet,
                                      int index,
                                      int[] arr,
                                      ArrayList<ArrayList<Integer>> sets) {
        for (int i = index + 2; i < arr.length; i++) {
            ArrayList<Integer> newSet = new ArrayList<>(currentSet);
            newSet.add(arr[i]);
            sets.add(newSet);
            enrichSetAndAddToList(newSet, i, arr, sets);
        }
    }

    static long getMaxSum(ArrayList<ArrayList<Integer>> sets) {
        return sets.stream()
                .map((n) -> n.stream()
                        .reduce(0, (a, b) -> a + b))
                .max(Integer::compareTo)
                .get();
    }
}
