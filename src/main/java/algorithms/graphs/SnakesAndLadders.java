package algorithms.graphs;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/the-quickest-way-up/problem
 */
public class SnakesAndLadders {

    public static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int[] distances = new int[101];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        Map<Integer, Integer> laddersMap = new HashMap<>();
        for (int[] l: ladders) {
            laddersMap.put(l[0], l[1]);
        }
        Map<Integer, Integer> snakesMap = new HashMap<>();
        for (int[] s: snakes) {
            snakesMap.put(s[0], s[1]);
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int currentPos = queue.poll();
            if (currentPos == 100) {
                return distances[100];
            }
            int newDistance = distances[currentPos];
            newDistance++;
            for (int i = 6; i >= 1; i--) {
                int newPos = currentPos + i;
                Integer ladderPos = laddersMap.get(newPos);
                Integer snakePos = snakesMap.get(newPos);
                if (ladderPos != null) {
                    if (distances[ladderPos] > newDistance) {
                        queue.add(ladderPos);
                        distances[ladderPos] = newDistance;
                    }
                } else if (snakePos != null) {
                    if (distances[snakePos] > newDistance) {
                        queue.add(snakePos);
                        distances[snakePos] = newDistance;
                    }
                } else if (newPos <= 100 && distances[newPos] > newDistance) {
                    queue.add(newPos);
                    distances[newPos] = newDistance;
                }
            }
        }
        return -1;
    }

}
