package algorithms.gcj2019.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class YouCanGoYourOwnWay {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int sideSize = in.nextInt();
            char[] path = in.next().toCharArray();
            char[] myPath = new char[path.length];

            for (int i = 0; i < path.length; i++) {
                if (path[i] == 'S') {
                    myPath[i] = 'E';
                } else if (path[i] == 'E'){
                    myPath[i] = 'S';
                }
            }

            System.out.printf("Case #%d: %s%n", t, String.valueOf(myPath));
        }
    }

}
