package puzzles.simplepuzzles;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    static List<Integer> dynamicArray(int seqAmount, List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();


        ArrayList<Integer>[] sequences = new ArrayList[seqAmount];
        for (int i = 0; i < seqAmount; i++) {
            sequences[i] = new ArrayList<>();
        }

        int lastAnswer = 0;
        int seqIndex;
        for (List<Integer> query : queries) {
            seqIndex = (query.get(1) ^ lastAnswer) % seqAmount;
            if (query.get(0).equals(1)) {
                sequences[seqIndex].add(query.get(2));
            }
            else if (query.get(0).equals(2)) {
                lastAnswer = sequences[seqIndex].get(query.get(2) % sequences[seqIndex].size());
                results.add(lastAnswer);
            }
        }

        return results;
    }
}
