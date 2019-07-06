package algorithms.trees;

import java.util.Optional;

public class SearchWordInTrie {

    private Trie trie = new Trie();

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (!word.contains(".")) {
            return trie.countExactMatchString(word) > 0;
        }
        Optional<Boolean> optional = trie.root.childrenStream()
                .map(n -> dfs(word, 0, n))
                .filter(e -> e == true)
                .findFirst();
        if (optional.isPresent()) {
            return true;
        }
        return false;
    }

    private boolean dfs(final String word, final int i, final Trie.Node node) {
        if (i == word.length() - 1) {
            return node.isEndOfString() && (word.charAt(i) == '.' || node.valueEquals(word.charAt(i)));
        }
        if (word.charAt(i) == '.' || node.valueEquals(word.charAt(i))) {
            Optional<Boolean> optional = node.childrenStream()
                    .map(n -> dfs(word, i+1, n))
                    .filter(e -> e == true)
                    .findFirst();
            if (optional.isPresent()) {
                return true;
            }
        }

        return false;
    }

}
