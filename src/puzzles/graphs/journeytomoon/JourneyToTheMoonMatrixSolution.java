package puzzles.graphs.journeytomoon;

import java.util.Arrays;

public class JourneyToTheMoonMatrixSolution implements JourneyToTheMoon {

    @Override
    public long getJourneyToMoonPairs(int astronautsAmount, int[][] astronautsFromSameCountry) {
        int[][] graphAstronauts = new int[astronautsAmount][astronautsAmount];
        for (int i = 0; i < astronautsAmount; i++) {
            Arrays.fill(graphAstronauts[i], 1);
            graphAstronauts[i][i] = 0;
        }

        for (int[] pair : astronautsFromSameCountry) {
            eliminateAstronautsFromSameCountry(pair[0], pair[1], graphAstronauts);
        }

        int pairs = 0;
        for (int i = 0; i < graphAstronauts.length; i++)
            for (int j = i + 1; j < graphAstronauts.length; j++) {
                if (graphAstronauts[i][j] == 1) {
                    pairs++;
                }
            }

        return pairs;
    }

    static void eliminateAstronautsFromSameCountry(int a, int b, int[][] graphAstronauts) {
        if (graphAstronauts[a][b] == 0) {
            return;
        }

        graphAstronauts[a][b] = graphAstronauts[b][a] = 0;

        for (int j = 0; j < graphAstronauts.length; j++) {
            if (graphAstronauts[a][j] == 0 && a != j && j != b) {
                eliminateAstronautsFromSameCountry(b, j, graphAstronauts);
            }
            if (graphAstronauts[b][j] == 0 && b != j && j != a) {
                eliminateAstronautsFromSameCountry(a, j, graphAstronauts);
            }
        }
    }
}
