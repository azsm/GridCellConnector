package zouzou.algorithm.search.connectedarea;

import org.junit.Assert;
import org.junit.Test;

public class MaxConnectedAreaAlgorithmExecutorTester {

    @Test
    public void with_one_area_size_1() {
        int[][] matrix = {{0, 0}, {0, 1}};
        MaxConnectedAreaAlgorithmExecutor algo = new MaxConnectedAreaAlgorithmExecutor();
        Assert.assertEquals(1, algo.compute(matrix));
    }

    @Test
    public void with_one_area_size_4() {
        int[][] matrix = {{0, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        MaxConnectedAreaAlgorithmExecutor algo = new MaxConnectedAreaAlgorithmExecutor();
        Assert.assertEquals(4, algo.compute(matrix));
    }

    @Test
    public void with_two_areas() {
        int[][] matrix = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        MaxConnectedAreaAlgorithmExecutor algo = new MaxConnectedAreaAlgorithmExecutor();
        Assert.assertEquals(5, algo.compute(matrix));
    }
}
