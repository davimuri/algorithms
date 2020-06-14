package algorithms.graphs;

import java.util.*;

/**
 * There are n cities connected by m flights.
 * Each flight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops.
 * If there is no such route, output -1.
 * Reference: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
 */
public class CheapestFlightsWithinKStops {

    /**
     *
     * @param n
     * @param flights each flight is an array [u, v, w]
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] adjacencyList = toAdjacencyList(n, flights);
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        dfs(adjacencyList, costs, src, 0, 0, dst, K);
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

    private void dfs(List<int[]>[] adjacencyList, int[] costs,
                    int current, int sumCost, int stopsCount, int dst, int K) {

        if (costs[current] >= sumCost) {
            costs[current] = sumCost;
        }
        if (stopsCount > K || current == dst || sumCost > costs[dst]) {
            return;
        }
        List<int[]> flightOptions =  adjacencyList[current];
        if (flightOptions == null) return;
        for (int[] flight: flightOptions) {
            dfs(adjacencyList, costs, flight[1], sumCost+flight[2],
                    stopsCount+1, dst, K);
        }
    }

    private List<int[]>[] toAdjacencyList(int n, int[][] flights) {
        List<int[]>[] adjacencyList = new List[n];
        for (int[] flight: flights) {
            List<int[]> nodes = adjacencyList[flight[0]] != null
                    ? adjacencyList[flight[0]]
                    : new ArrayList<>();
            nodes.add(flight);
            adjacencyList[flight[0]] = nodes;
        }
        return adjacencyList;
    }

}
