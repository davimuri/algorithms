package algorithms.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Trie {

    public class Node {
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

        return optionalNode.map(n -> n.countEndOfString).orElse(0);
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
