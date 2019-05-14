package algorithms.gcj2019.r1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AlienRhyme {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numberOfStrings = in.nextInt();
            String[] words = new String[numberOfStrings];
            for (int i = 0; i < numberOfStrings; i++) {
                words[i] = in.next();
            }

            System.out.printf("Case #%d: %d%n", t, maxPairWords(words));
        }

    }

    public static int maxPairWords(String[] words) {

        List<char[]> reversedWords = toReversedCharArray(words);
        return groupByCharAtIndex(reversedWords, 0);
    }

    public static List<char[]> toReversedCharArray(String[] words) {
        List<char[]> reversedWords = new ArrayList<>(words.length);
        for (String w : words) {
            reversedWords.add(new StringBuilder(w).reverse().toString().toCharArray());
        }
        return reversedWords;
    }

    private static int groupByCharAtIndex(final List<char[]> group, final int index) {
        if (group.isEmpty() || group.size() == 1) {
            return 0;
        }
        if (group.size() <= 3 && index > 0) {
            return 2;
        }

        Map<Character, List<char[]>> groups = new HashMap<>();
        for (char[] word : group) {
            if (index >= word.length) continue;

            List<char[]> newGroup = groups.get(word[index]);
            if (newGroup == null) {
                newGroup = new ArrayList<>();
            }
            newGroup.add(word);
            groups.put(word[index], newGroup);
        }

        if (index == 0 && groups.size() == group.size()) {
            return 0;
        }

        int count = thereAreAtLeastTwoGroupsOfSizeOne(groups) ? 2 : 0;

        return count + groups.values().stream()
                .filter(g -> g.size() > 1)
                .mapToInt(g -> groupByCharAtIndex(g, index+1))
                .sum();
    }

    private static boolean thereAreAtLeastTwoGroupsOfSizeOne(Map<Character, List<char[]>> groups) {
        return 2 <= groups.values().stream()
                .mapToInt(l -> l.size())
                .filter(s -> s == 1)
                .sum();
    }
}
