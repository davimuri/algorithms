package algorithms.trees;

import org.junit.Assert;
import org.junit.Test;

public class SearchWordInTrieTest {

    @Test
    public void testEmptyEngine() {
        SearchWordInTrie engine = new SearchWordInTrie();
        Assert.assertFalse(engine.search("monitor"));
    }

    @Test
    public void testEmptySearchString() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("aa");
        Assert.assertFalse(engine.search(""));
    }

    @Test
    public void testEmptySearchStringTrue() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("");
        Assert.assertTrue(engine.search(""));
    }

    @Test
    public void testHappyCase() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("monitor");
        engine.addWord("mouse");
        engine.addWord("keyboard");
        Assert.assertEquals(true, engine.search("monitor"));
        Assert.assertEquals(true, engine.search("mouse"));
        Assert.assertEquals(true, engine.search("keyboard"));
        Assert.assertEquals(false, engine.search("key"));
        Assert.assertEquals(false, engine.search("board"));
    }

    @Test
    public void testAllWildcardCase() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("abc");
        Assert.assertTrue(engine.search("..."));
        Assert.assertFalse(engine.search(".."));
    }

    @Test
    public void testWildcardCase() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("monitor");
        engine.addWord("mouse");
        engine.addWord("keyboard");
        Assert.assertEquals(true, engine.search(".onitor"));
        Assert.assertEquals(true, engine.search("mou.."));
        Assert.assertEquals(true, engine.search(".eyboar."));
        Assert.assertEquals(false, engine.search(".ey"));
        Assert.assertEquals(false, engine.search(".board"));
    }

    @Test
    public void testWildcardCaseWithMultipleSolutions() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("bad");
        engine.addWord("mad");
        Assert.assertEquals(true, engine.search(".a."));
        Assert.assertEquals(true, engine.search(".ad"));
    }

    @Test
    public void testWildcardCaseInTheMiddle() {
        SearchWordInTrie engine = new SearchWordInTrie();
        engine.addWord("foozbar");
        Assert.assertEquals(true, engine.search("foo.bar"));
        Assert.assertEquals(true, engine.search("fo..bar"));
        Assert.assertEquals(true, engine.search("fo...ar"));
    }

}
