package algorithms.gcj2019.r1a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class AlienRhymeTrie {

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
        Trie trie = new Trie();
        List<String> reversedWords = toReversedCharArray(words);
        for (String str : reversedWords) {
            trie.add(str);
        }

        return words.length - countUnpairedWords(trie.root);
    }


    public static List<String> toReversedCharArray(String[] words) {
        List<String> reversedWords = new ArrayList<>(words.length);
        for (String w : words) {
            reversedWords.add(new StringBuilder(w).reverse().toString());
        }
        return reversedWords;
    }

    private static int countUnpairedWords(Trie.Node node) {
        if (node.isLeaf()) {
            return 1;
        }
        int childrenCount = node.isEndOfString() ? 1 : 0;
        childrenCount += node.childrenStream().mapToInt(n -> countUnpairedWords(n)).sum();
        if (!node.isRoot() && childrenCount >= 2) {
            return childrenCount - 2;
        }

        return childrenCount;
    }

    static class Trie {

        class Node {
            char value;
            private Map<Character, Node> children = new HashMap<>();
            private int countEndOfString = 0;

            private Node(char val) {
                value = val;
            }

            public boolean isLeaf() {
                return children.size() == 0;
            }

            public boolean isRoot() {
                return value == '/';
            }

            public boolean isEndOfString() {
                return countEndOfString > 0;
            }

            public Stream<Node> childrenStream() {
                return children.values().stream();
            }
        }

        public Node root = new Node('/');

        public void add(String str) {
            addChild(root, str, 0);
        }

        private void addChild(Node node, String str, int index) {
            if (index == str.length()) {
                node.countEndOfString++;
                return;
            }

            Node child = node.children.get(str.charAt(index));
            if (child == null) {
                child = new Node(str.charAt(index));
                node.children.put(str.charAt(index), child);
            }

            addChild(child, str, index + 1);
        }

        public int countExactMatchString(String str) {
            Optional<Node> optionalNode = findLastNode(root, str, 0);
            if (!optionalNode.isPresent()) {
                return 0;
            }

            return optionalNode.get().countEndOfString;
        }

        private Optional<Node> findLastNode(Node node, String str, int index) {
            if (index == str.length()) {
                return Optional.of(node);
            }
            Node child = node.children.get(str.charAt(index));
            if (child == null) {
                return Optional.empty();
            }
            return findLastNode(child, str, index + 1);
        }
    }

}
