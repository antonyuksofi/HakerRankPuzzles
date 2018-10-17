package puzzles.graphs;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class RoadsLibraries {
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int citiesAmount, int costLib, int costRoad, int[][] roadsBetweenCities) {
        if (costLib <= costRoad) {
            return costLib * citiesAmount;
        }

        long totalCost = 0;

        boolean[][] graph = getGraph(roadsBetweenCities, citiesAmount);
        boolean[] citiesVisitedList = new boolean[citiesAmount];
        int citiesVisitedAmount = 0;


        while (citiesVisitedAmount < citiesAmount) {
            int startCityIndex = findFirstUnvisitedCity(citiesVisitedList);
            if (startCityIndex == -1) {
                throw new NoSuchElementException("No cities unvisited left");
            }

            int connectedCitiesFound = BFS(graph, citiesVisitedList, startCityIndex);
            citiesVisitedAmount += connectedCitiesFound;
            totalCost += (long) (connectedCitiesFound - 1) * costRoad + (long) costLib;
        }

        return totalCost;
    }

    static boolean[][] getGraph(int[][] roadsBetweenCities, int citiesAmount) {
        boolean[][] graph = new boolean[citiesAmount][citiesAmount];
        for (int[] road : roadsBetweenCities) {
            graph[road[0] - 1][road[1] - 1] = graph[road[1] - 1][road[0] - 1] = true;
        }
        return graph;
    }


    static int BFS(boolean[][] graph, boolean[] citiesVisited, int startCityIndex) {
        int currentCity = findFirstUnvisitedCity(citiesVisited);
        if (currentCity == -1) {
            throw new NoSuchElementException("No cities unvisited left");
        }

        int citiesConnected = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(currentCity);
        while (!queue.isEmpty()) {
            processCityOnQueueTop(queue, citiesVisited, graph);
            citiesConnected++;
        }

        return citiesConnected;
    }

    static void processCityOnQueueTop(ArrayDeque<Integer> queue, boolean[] citiesVisited, boolean[][] graph) {
        int cityIndex = queue.poll();

        // add children to queue
        for (int i = 0; i < graph[cityIndex].length; i++) {
            if (graph[cityIndex][i] && !citiesVisited[i]) {
                queue.add(i);
                citiesVisited[i] = true;
            }
        }

        // mark as visited
        citiesVisited[cityIndex] = true;
    }

    static int findFirstUnvisitedCity(boolean[] citiesVisited) {
        for (int i = 0; i < citiesVisited.length; i++) {
            if (!citiesVisited[i]) {
                return i;
            }
        }
        return -1;
    }
}
