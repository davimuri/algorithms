package algorithms.gcj2019.r0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// TODO Seems like implementation is ok but I'm getting Time Limit Exceeded result
public class DatBae {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            testCase(in);
        }
    }

    private static void testCase(Scanner in) {
        int workers = in.nextInt();
        int brokenWorkers = in.nextInt();
        int chancesToAsk = in.nextInt();
        int max = Math.min((int)Math.pow(2, chancesToAsk), workers);
        char[][] answers = new char[chancesToAsk][];

        for (int i = 0; i < chancesToAsk; i++) {
            System.out.println(fillBits(bits(i, max), workers));
            System.out.flush();
            answers[i] = in.nextLine().toCharArray();
        }

        System.out.println(identifyBrokenWorkers(answers, workers, brokenWorkers, max));
        System.out.flush();
        int success = in.nextInt();
        if (success == -1) {
            System.exit(0);
        }
    }

    public static String bits(int row, int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append( ( (1<<row) & i )  == 0 ? "0" : "1");
        }
        return sb.toString();
    }

    public static String fillBits(String bits, int length) {
        assert bits.length() <= length;
        if (bits.length() == length) {
            return bits;
        }

        int groups = length / bits.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= groups; i++) {
            sb.append(bits);
        }
        int additionalPositions = length % bits.length();
        char[] bitsArray = bits.toCharArray();
        for (int i = 0; i < additionalPositions; i++) {
            sb.append(bitsArray[i]);
        }
        return sb.toString();
    }

    public static String identifyBrokenWorkers(char[][] answers, int workers, int brokenWorkers, int max) {
        StringBuilder sb = new StringBuilder();
        int currentValue = 0;
        int workerIndex = 0;
        int col = 0;
        while (col < answers[0].length) {
            String currentValueBinary = Integer.toBinaryString(currentValue);
            int index = currentValueBinary.length() - 1;
            boolean workerBroken = false;
            for (int i = 0; i < answers.length && !workerBroken; i++) {
                if ((index >= 0 && answers[i][col] != currentValueBinary.charAt(index))
                || (index < 0 && answers[i][col] != '0')) {
                    sb.append(workerIndex);
                    sb.append(" ");
                    workerBroken = true;
                }
                index--;
            }
            if (!workerBroken) {
                col++;
            }
            currentValue = (currentValue + 1) % (max + 1);
            workerIndex++;
        }

        while (workerIndex < workers) {
            sb.append(workerIndex++);
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

}
