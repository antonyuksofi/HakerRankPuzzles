package puzzles.graphs.journeytomoon;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class JourneyToTheMoonSetsSolution implements JourneyToTheMoon {

    int indexOfLastSearch;

    @Override
    public long getJourneyToMoonPairs(int astronautsAmount, int[][] astronautsFromSameCountry) {
        indexOfLastSearch = 0;
        ArrayList<Integer>[] graphAstronauts = new ArrayList[astronautsAmount];
        for (int i = 0; i < astronautsAmount; i++) {
            graphAstronauts[i] = new ArrayList<>();
        }

        // filling the graph, presented as adjacency list
        for (int[] pair : astronautsFromSameCountry) {
            graphAstronauts[pair[0]].add(pair[1]);
            graphAstronauts[pair[1]].add(pair[0]);
        }

        ArrayList<Integer> connectedComponentSizes = calculateConnectedComponentsSizes(astronautsAmount, graphAstronauts);

        return calculatePossiblePairsAmount(connectedComponentSizes);
    }

    private long calculatePossiblePairsAmount(ArrayList<Integer> connectedComponentSizes) {
        if (connectedComponentSizes.isEmpty()) {
            return 0;
        }

        long pairsAmount = 0;

        // greedy solution (linear instead of O(n2))
        long sumForNextStep = connectedComponentSizes.get(0);
        for (int i = 1; i < connectedComponentSizes.size(); i++) {
            pairsAmount += sumForNextStep * connectedComponentSizes.get(i);
            sumForNextStep += connectedComponentSizes.get(i);
        }

        return pairsAmount;
    }

    private ArrayList<Integer> calculateConnectedComponentsSizes(int astronautsAmount,
                                                                 ArrayList<Integer>[] graphAstronauts) {
        // bfs
        boolean[] visitedVerticesList = new boolean[astronautsAmount];
        int visitedVerticesAmount = 0;
        ArrayList<Integer> connectedComponentsSizes = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int currentComponentSize = 0;

        while (visitedVerticesAmount < visitedVerticesList.length) {
            if (queue.isEmpty()) {
                int indexOfNewVertex = getNewUnvisitedVertex(visitedVerticesList);

                // if the vertex isn't connected with any other
                if (graphAstronauts[indexOfNewVertex].isEmpty()) {
                    visitedVerticesAmount++;
                    visitedVerticesList[indexOfNewVertex] = true;
                    connectedComponentsSizes.add(1);
                    continue;
                }

                queue.add(indexOfNewVertex);
            }

            int resultOfVertexProcessing = processHeadOfQueue(queue, graphAstronauts, visitedVerticesList);
            visitedVerticesAmount += resultOfVertexProcessing;
            currentComponentSize += resultOfVertexProcessing;

            if (queue.isEmpty()) {
                connectedComponentsSizes.add(currentComponentSize);
                currentComponentSize = 0;
            }
        }

        return connectedComponentsSizes;
    }

    private int getNewUnvisitedVertex(boolean[] visitedVerticesList) {
        for (int i = indexOfLastSearch; i < visitedVerticesList.length; i++) {
            if (!visitedVerticesList[i]) {
                indexOfLastSearch = i + 1;
                return i;
            }
        }
        indexOfLastSearch = visitedVerticesList.length;
        return -1;
    }

    private int processHeadOfQueue(ArrayDeque<Integer> queue,
                                   ArrayList<Integer>[] graphAstronauts,
                                   boolean[] visitedVertices) {
        int indexOfCurrentVertex = queue.pop();

        if (visitedVertices[indexOfCurrentVertex]) {
            return 0;
        }

        for (Integer adjacentVertexIndex : graphAstronauts[indexOfCurrentVertex]) {
            if (!visitedVertices[adjacentVertexIndex]) {
                queue.add(adjacentVertexIndex);
            }
        }

        visitedVertices[indexOfCurrentVertex] = true;
        return 1;
    }
}
