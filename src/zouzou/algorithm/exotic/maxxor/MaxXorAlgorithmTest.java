package zouzou.algorithm.exotic.maxxor;

import org.junit.Assert;
import org.junit.Test;

public class MaxXorAlgorithmTest {
    @Test
    public void rangeTest1() {
        int[] resultAlgo = new MaxXorAlgorithm().getMaxXor(new int[]{3, 7, 15, 10}, new int[]{3});
        Assert.assertEquals(1, resultAlgo.length);
        Assert.assertEquals(12, resultAlgo[0]);
    }

    @Test
    public void rangeTest2() {
        int[] resultAlgo = new MaxXorAlgorithm().getMaxXor(new int[]{0, 1, 2}, new int[]{3, 7, 2});
        Assert.assertEquals(3, resultAlgo[0]);
        Assert.assertEquals(7, resultAlgo[1]);
        Assert.assertEquals(3, resultAlgo[2]);
    }
}
