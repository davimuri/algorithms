package algorithms.gcj2019.r1b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManhattanCrepeCartBruteForce {

    private class Person {
        int x, y;
        char direction;

    }

    private class Pair<X, Y> {
        X x;
        Y y;

        Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        X getX() { return x; }
    }

    public int[] find(int gridSize, List<Person> persons) {
        int[][] grid = new int[gridSize+1][gridSize+1];
        for (Person p : persons) {
            countIntersections(grid, p);
        }

        int max = -1;
        List<Pair<Integer, Integer>> intersections = new ArrayList<>();
        for (int i = 0; i <= gridSize; i++) {
            for (int j = 0; j <= gridSize; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    intersections = new ArrayList<>();
                    intersections.add(new Pair(i, j));
                } else if (grid[i][j] == max) {
                    intersections.add(new Pair(i, j));
                }
            }
        }

        //Comparator<Pair<Integer, Integer>> comp = Comparator.comparing(p -> p.).thenComparing(p -> p.y);
        //Collections.sort(intersections, comp);


        return new int[] {1, 2};
    }

    public void countIntersections(int[][] grid, Person person) {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        switch(person.direction) {
            case 'N':
                x1 = 0;
                x2 = grid.length - 1;
                y1 = 0;
                y2 = Math.max(person.y - 1, 0);
                break;
            case 'S':
                x1 = 0;
                x2 = grid.length - 1;
                y1 = Math.min(person.y + 1, grid.length - 1);
                y2 = grid.length - 1;
                break;
            case 'E':
                x1 = Math.min(person.x + 1, grid.length - 1);
                x2 = grid.length - 1;
                y1 = 0;
                y2 = grid.length - 1;
                break;
            case 'W':
                x1 = 0;
                x2 = Math.max(person.x - 1, grid.length - 1);
                y1 = 0;
                y2 = grid.length - 1;
                break;
            default: assert true : "wrong direction " + person.direction;
        }

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                grid[i][j]++;
            }
        }
    }
}
