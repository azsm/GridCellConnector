package zouzou.algorithm.exotic.maxxor;

import org.junit.Assert;
import org.junit.Test;

public class NumPrefixTreeTest {
    @Test
    public void is_world_exists() {
        NumPrefixTree prefixTree = new NumPrefixTree();
        prefixTree.insert(5);
        prefixTree.insert(7);
        prefixTree.insert(2);
        prefixTree.insert(4);
        prefixTree.displayAllWorld();
        Assert.assertEquals(true, prefixTree.contains(5));
        Assert.assertEquals(true, prefixTree.contains(2));
        Assert.assertEquals(true, prefixTree.contains(4));
        Assert.assertEquals(true, prefixTree.contains(7));
    }

    @Test
    public void is_world_not_exists() {
        NumPrefixTree prefixTree = new NumPrefixTree();
        prefixTree.insert(3);
        prefixTree.insert(7);
        prefixTree.insert(15);
        prefixTree.insert(10);
        prefixTree.displayAllWorld();
        Assert.assertEquals(true, prefixTree.contains(3));
        Assert.assertEquals(true, prefixTree.contains(7));
        Assert.assertEquals(true, prefixTree.contains(15));
        Assert.assertEquals(true, prefixTree.contains(10));
    }
}
