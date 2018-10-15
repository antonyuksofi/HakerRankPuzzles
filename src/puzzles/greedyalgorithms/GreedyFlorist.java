package puzzles.greedyalgorithms;

import java.util.Arrays;
import java.util.Collections;

public class GreedyFlorist {
    static int getMinimumCost(int customersAmount, int[] flowersPrice) {
        int minCost = 0;

        flowersPrice = Arrays.stream(flowersPrice)
                .sorted()
                .toArray();

        int currentMultiplier = 1;
        int customersToPurchaseWithCurrentMultiplier = customersAmount;
        for (int i = flowersPrice.length - 1; i >= 0; i--) {
            if (customersToPurchaseWithCurrentMultiplier == 0) {
                customersToPurchaseWithCurrentMultiplier = customersAmount;
                currentMultiplier++;
            }
            minCost += flowersPrice[i] * currentMultiplier;
            customersToPurchaseWithCurrentMultiplier--;
        }

        return minCost;
    }
}
