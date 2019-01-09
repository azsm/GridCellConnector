package zouzou.algorithm.exotic.dictionary;

import org.junit.Assert;
import org.junit.Test;

public class PrefixTreeTest {
    @Test
    public void is_world_exists() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("zaza");
        prefixTree.insert("toto");
        prefixTree.insert("titi");
        prefixTree.insert("zouzou");
        prefixTree.displayAllWorld();
        Assert.assertEquals(true, prefixTree.contains("toto"));
    }

    @Test
    public void is_world_not_exists() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("toto");
        Assert.assertEquals(false, prefixTree.contains("titi"));
    }
}
