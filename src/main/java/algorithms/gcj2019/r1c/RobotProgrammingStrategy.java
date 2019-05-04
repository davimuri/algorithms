package algorithms.gcj2019.r1c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotProgrammingStrategy {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int opponents = in.nextInt();
            List<Robot> robots = new ArrayList<>(opponents);

            for (int i = 0; i < opponents; i++) {
                robots.add(new Robot(in.next()));
            }

            String myProgram = solve(robots);
            System.out.printf("Case #%d: %s%n", t, myProgram);
        }
    }

    static class Robot {
        String program;
        int index = 0;

        Robot(String program) {
            this.program = program;
        }

        char currentMove() {
            return program.charAt(index);
        }

        char currentMoveAndApply() {
            char move = program.charAt(index);
            index = (index + 1) % program.length();
            return move;
        }
    }

    public static String solve(List<Robot> robots) {
        if (robots == null || robots.isEmpty()) {
            return "IMPOSSIBLE";
        }

        StringBuilder myProgram = new StringBuilder();
        boolean[] losers = new boolean[robots.size()];

        while (atLeastOneActiveOpponent(losers) && myProgram.length() <= robots.size()) {
            char myMove = myMove(robots, losers);

            if (myMove == '#') {
                return "IMPOSSIBLE";
            }

            myProgram.append(myMove);
            identifyLoosersAfterMyMove(myMove, robots, losers);
        }

        if (myProgram.length() > robots.size()) {
            return "IMPOSSIBLE";
        }

        return myProgram.toString();
    }

    private static boolean atLeastOneActiveOpponent(boolean[] losers) {
        for (boolean b : losers) {
            if (!b) {
                return true;
            }
        }
        return false;
    }

    private static char myMove(List<Robot> robots, boolean[] losers) {
        int[] prsWinCounter = new int[3];

        for (int i = 0; i < robots.size(); i++) {
            if (!losers[i]) {
                char opponentMove = robots.get(i).currentMove();
                switch (opponentMove) {
                    case 'R':
                        if (prsWinCounter[0] != -1) {
                            prsWinCounter[0]++;
                        }
                        prsWinCounter[2] = -1;
                        break;
                    case 'S':
                        if (prsWinCounter[1] != -1) {
                            prsWinCounter[1]++;
                        }
                        prsWinCounter[0] = -1;
                        break;
                    case 'P':
                        if (prsWinCounter[2] != -1) {
                            prsWinCounter[2]++;
                        }
                        prsWinCounter[1] = -1;
                        break;
                }
                if (prsWinCounter[0] + prsWinCounter[1] + prsWinCounter[2] == -3) {
                    return '#'; // no possible move
                }
            }
        }

        if (prsWinCounter[0] > prsWinCounter[1] && prsWinCounter[0] > prsWinCounter[2]) {
            return 'P';
        }
        if (prsWinCounter[1] > prsWinCounter[0] && prsWinCounter[1] > prsWinCounter[2]) {
            return 'R';
        }
        if (prsWinCounter[2] > prsWinCounter[0] && prsWinCounter[2] > prsWinCounter[1]) {
            return 'S';
        }

        return '#';
    }

    private static void identifyLoosersAfterMyMove(char myMove, List<Robot> robots, boolean[] losers) {
        for (int i = 0; i < robots.size(); i++) {
            if (!losers[i]) {
                char opponentMove = robots.get(i).currentMoveAndApply();
                if ((myMove == 'P' &&  opponentMove == 'R')
                    || (myMove == 'R' &&  opponentMove == 'S')
                    || (myMove == 'S' &&  opponentMove == 'P')){

                    losers[i] = true;
                }
            }
        }
    }
}
