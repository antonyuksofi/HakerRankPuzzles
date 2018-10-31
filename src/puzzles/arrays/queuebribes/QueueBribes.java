package puzzles.arrays.queuebribes;

import java.util.HashSet;

public class QueueBribes {

    static int getMinimumBribesAmount(int[] queue) {
        int bribesAmount = 0;
        HashSet<Integer> visited = new HashSet<>(queue.length);
        int minNumberPassed = -1;

        for (int i = 0; i < queue.length; i++) {

            visited.add(queue[i]);
            int currentIndex = i + 1;

            if (queue[i] > currentIndex) {
                if (queue[i] - currentIndex > 2) {
                    return -1;
                }
                bribesAmount += queue[i] - currentIndex;
                if (minNumberPassed == -1) {
                    minNumberPassed = currentIndex;
                }
            } else if (minNumberPassed != -1 && queue[i] > minNumberPassed) {
                bribesAmount++;
            } else if (queue[i] == minNumberPassed) {
                minNumberPassed = findNewMinNumberPassed(visited, minNumberPassed, currentIndex);
            }
        }

        return bribesAmount;
    }

    static int findNewMinNumberPassed(HashSet<Integer> visited, int previousMinNumPassed, int currentIndex) {
        for (int i = previousMinNumPassed + 1; i <= currentIndex; i++) {
            if (!visited.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
