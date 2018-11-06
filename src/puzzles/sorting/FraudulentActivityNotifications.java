package puzzles.sorting;

public class FraudulentActivityNotifications {
    //expenditures[i] - from 0 to 200
    static int activityNotifications(int[] expenditures, int daysOfTrailing) {
        int notificationsAmount = 0;
        int[] countingSortServiceArray = new int[201];

        fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, daysOfTrailing);

        for (int i = daysOfTrailing; i < expenditures.length; i++) {
            double median = getMedianValue(countingSortServiceArray, daysOfTrailing);

            if (expenditures[i] >= median * 2) {
                notificationsAmount++;
            }

            removeElementFromCountingSortServiceArray(countingSortServiceArray, expenditures[i - daysOfTrailing]);
            addElementToCountingSortServiceArray(countingSortServiceArray, expenditures[i]);
        }

        return notificationsAmount;
    }

    static void removeElementFromCountingSortServiceArray(int[] countingSortServiceArray, int valueToDelete) {
        for (int i = valueToDelete; i < countingSortServiceArray.length; i++) {
            countingSortServiceArray[i]--;
        }
    }

    static void addElementToCountingSortServiceArray(int[] countingSortServiceArray, int valueToAdd) {
        for (int i = valueToAdd; i < countingSortServiceArray.length; i++) {
            countingSortServiceArray[i]++;
        }
    }

    static double getMedianValue(int[] countingSortServiceArray, int daysOfTrailing) {
        double median;
        if (daysOfTrailing % 2 == 1) {
            median = getElementByPosition(countingSortServiceArray, daysOfTrailing / 2);
        } else {
            median = (double) (getElementByPosition(countingSortServiceArray, daysOfTrailing / 2) +
                    getElementByPosition(countingSortServiceArray, daysOfTrailing / 2 - 1)) / 2;
        }
        return median;
    }

    static int getElementByPosition(int[] countingSortServiceArray, int position) {
        // first n empty element have zeros in countingSortServiceArray, that's why increase
        position++;
        for (int i = 0; i < countingSortServiceArray.length; i++) {
            if (countingSortServiceArray[i] >= position) {
                return i;
            }
        }
        return -1;
    }

    static void fillCountingSortServiceArrayForFirstDaysOfTrailing(int[] expenditures, int[] countingSortServiceArray, int daysOfTrailing) {
        for (int i = 0; i < daysOfTrailing; i++) {
            int singleExpenditureAmount = expenditures[i];
            countingSortServiceArray[singleExpenditureAmount]++;
        }

        for (int i = 1; i < countingSortServiceArray.length; i++) {
            countingSortServiceArray[i] += countingSortServiceArray[i - 1];

        }
    }
}