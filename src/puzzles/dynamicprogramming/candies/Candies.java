package puzzles.dynamicprogramming.candies;

public class Candies {
    static long candies(int[] childrenScores) {
        int amountOfBetterBeforeCurrent = 0;
        long candies = 1;
        int candiesOfLastChild = 1;

        int localMaxCandiesAmount = 0;

        for (int i = 1; i < childrenScores.length; i++) {
            if (childrenScores[i] == childrenScores[i - 1]) {
                amountOfBetterBeforeCurrent = 0;
                candies += 1;
                candiesOfLastChild = 1;

                localMaxCandiesAmount = candiesOfLastChild;
            } else if (childrenScores[i] < childrenScores[i - 1]) {
                amountOfBetterBeforeCurrent += 1;
                candiesOfLastChild = 1;

                if (localMaxCandiesAmount > amountOfBetterBeforeCurrent) {
                    candies += (candiesOfLastChild + amountOfBetterBeforeCurrent - 1);
                } else {
                    candies += (candiesOfLastChild + amountOfBetterBeforeCurrent);
                    localMaxCandiesAmount++;
                }
            } else if (childrenScores[i] > childrenScores[i - 1]) {
                amountOfBetterBeforeCurrent = 0;
                candiesOfLastChild += 1;
                candies += candiesOfLastChild;

                localMaxCandiesAmount = candiesOfLastChild;
            }
        }

        return candies;
    }
}
