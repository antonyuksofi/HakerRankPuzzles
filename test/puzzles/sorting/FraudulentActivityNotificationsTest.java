package puzzles.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FraudulentActivityNotificationsTest {

    @Test
    public void activityNotifications() throws Exception {
        assertEquals(2, FraudulentActivityNotifications.activityNotifications(
                new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
        assertEquals(0, FraudulentActivityNotifications.activityNotifications(
                new int[]{1, 2, 3, 4, 4}, 4));
    }

    @Test
    public void fillOccurrencesForDaysRange() throws Exception {
        int[] expenditures = new int[]{1, 2, 3, 4, 4};
        int[] countingSortServiceArray = new int[201];
        FraudulentActivityNotifications.fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, 4);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 4, 4, 4, 4, 4}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
    }

    @Test
    public void removeElementFromCountingSortServiceArray() throws Exception {
        int[] expenditures = new int[]{1, 2, 3, 4};
        int[] countingSortServiceArray = new int[201];
        FraudulentActivityNotifications.fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, 4);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 4, 4, 4, 4, 4}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
        FraudulentActivityNotifications.removeElementFromCountingSortServiceArray(countingSortServiceArray, 1);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3, 3, 3, 3, 3, 3}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
    }

    @Test
    public void addElementToCountingSortServiceArray() throws Exception {
        int[] expenditures = new int[]{1, 2, 3, 4};
        int[] countingSortServiceArray = new int[201];
        FraudulentActivityNotifications.fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, 4);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 4, 4, 4, 4, 4}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
        FraudulentActivityNotifications.addElementToCountingSortServiceArray(countingSortServiceArray, 1);
        assertArrayEquals(new int[]{0, 2, 3, 4, 5, 5, 5, 5, 5, 5}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
        FraudulentActivityNotifications.addElementToCountingSortServiceArray(countingSortServiceArray, 7);
        assertArrayEquals(new int[]{0, 2, 3, 4, 5, 5, 5, 6, 6, 6}, Arrays.copyOfRange(countingSortServiceArray, 0, 10));
    }

    @Test
    public void getElementByPosition() throws Exception {
        int[] expenditures = new int[]{11, 12, 13, 14, 14};
        int[] countingSortServiceArray = new int[201];
        FraudulentActivityNotifications.fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, 4);
        assertEquals(11, FraudulentActivityNotifications.getElementByPosition(countingSortServiceArray, 0));
        assertEquals(12, FraudulentActivityNotifications.getElementByPosition(countingSortServiceArray, 1));
    }

    @Test
    public void getMedianValue() throws Exception {
        int[] expenditures = new int[]{2, 2, 4, 4};
        int[] countingSortServiceArray = new int[201];
        FraudulentActivityNotifications.fillCountingSortServiceArrayForFirstDaysOfTrailing(expenditures, countingSortServiceArray, 4);
        assertEquals(3, FraudulentActivityNotifications.getMedianValue(countingSortServiceArray, 4), 0.01);
        FraudulentActivityNotifications.addElementToCountingSortServiceArray(countingSortServiceArray, 3);
        assertEquals(3, FraudulentActivityNotifications.getMedianValue(countingSortServiceArray, 5), 0.01);
    }
}