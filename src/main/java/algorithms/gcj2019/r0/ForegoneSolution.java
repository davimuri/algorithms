package algorithms.gcj2019.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ForegoneSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String target = in.next();
            String[] vals = find(target);

            System.out.printf("Case #%d: %s %s%n", t, vals[0], vals[1]);
        }
    }

    public static String[] find(String target) {
        char[] chars = target.toCharArray();
        char[] val1 = new char[chars.length];
        StringBuilder sb = new StringBuilder();
        boolean first2 = false;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '4') {
                val1[i] = '2';
                sb.append("2");
                first2 = true;
            } else {
                val1[i] = chars[i];
                if (first2) {
                    sb.append("0");
                }
            }
        }
        String value2 = sb.toString();
        if (value2.isEmpty()) {
            value2 = "0";
        }

        return new String[] {new String(val1), value2};
    }

}
