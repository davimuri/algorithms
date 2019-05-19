package algorithms.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testTrieOneStringSizeOne() {
        Trie trie = new Trie();
        trie.add("A");
        int expected = 1;
        int actual = trie.countExactMatchString("A");
        assertEquals(expected, actual);
    }

    @Test
    public void testTrieTwoStringSizeOne() {
        Trie trie = new Trie();
        trie.add("A");
        trie.add("B");
        int expected = 1;
        int actual = trie.countExactMatchString("A");
        assertEquals(expected, actual);
        actual = trie.countExactMatchString("B");
        assertEquals(expected, actual);
    }

    @Test
    public void testTrieTwoStringPrefix() {
        Trie trie = new Trie();
        trie.add("A");
        trie.add("AB");
        int expected = 1;
        int actual = trie.countExactMatchString("A");
        assertEquals(expected, actual);
        actual = trie.countExactMatchString("AB");
        assertEquals(expected, actual);
    }

    @Test
    public void testTrieCommonPrefix() {
        Trie trie = new Trie();
        trie.add("SORPA");
        trie.add("SORP");
        trie.add("SORPB");
        trie.add("SORPC");
        assertEquals(1, trie.countExactMatchString("SORPA"));
        assertEquals(1, trie.countExactMatchString("SORP"));
        assertEquals(1, trie.countExactMatchString("SORPB"));
        assertEquals(1, trie.countExactMatchString("SORPC"));
    }

}
