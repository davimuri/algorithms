package algorithms.gcj2019;

import java.util.*;
import java.io.*;


/**
 * Annie is riding her horse to the east along a long and narrow one-way road that runs west to east. She is currently at kilometer 0 of the road, and her destination is at kilometer D; kilometers along the road are numbered from west to east.
 *
 * There are N other horses traveling east on the same road; all of them will go on traveling forever, and all of them are currently between Annie's horse and her destination. The i-th of these horses is initially at kilometer Ki and is traveling at its maximum speed of Si kilometers per hour.
 *
 * Horses are very polite, and a horse H1 will not pass (move ahead of) another horse H2 that started off ahead of H1. (Two or more horses can share the same position for any amount of time; you may consider the horses to be single points.) Horses (other than Annie's) travel at their maximum speeds, except that whenever a horse H1 catches up to another slower horse H2, H1 reduces its speed to match the speed of H2.
 *
 * Annie's horse, on the other hand, does not have a maximum speed and can travel at any speed that Annie chooses, as long as it does not pass another horse. To ensure a smooth ride for her and her horse, Annie wants to choose a single constant "cruise control" speed for her horse for the entire trip, from her current position to the destination, such that her horse will not pass any other horses. What is the maximum such speed that she can choose?
 */
public class CruiseControl {

    public static float calculateSpeed(int destination, List<int[]> positionAndSpeed) {

        Optional<Float> maxTime = positionAndSpeed.stream()
                .map(ps -> calculateTime(ps[0], destination, ps[1]))
                .max(Comparator.comparingDouble(e -> e.floatValue()));

        // speed = distance / time
        return (float)destination / maxTime.get();
    }

    private static float calculateTime(int position, int destination, int speed) {
        // time = distance / speed
        return (float)(destination - position) / (float)speed;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int destination = in.nextInt();
            int horses = in.nextInt();
            List<int[]> positionAndSpeed = new ArrayList<>(horses);

            for (int i = 1; i <= horses; i++) {
                positionAndSpeed.add(new int[] {in.nextInt(), in.nextInt()});
            }

            float res = calculateSpeed(destination, positionAndSpeed);
            System.out.printf("Case #%d: %f%n", t, res);
        }
    }

}
