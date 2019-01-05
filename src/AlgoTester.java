import org.junit.Assert;
import org.junit.Test;

public class AlgoTester {

    @Test
    public void with_one_area_size_1() {
        int[][] matrix = {{0, 0}, {0, 1}};
        MaxConnectedAreaAlgo algo = new MaxConnectedAreaAlgo();
        Assert.assertEquals(1, algo.compute(matrix));
    }

    @Test
    public void with_one_area_size_4() {
        int[][] matrix = {{0, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        MaxConnectedAreaAlgo algo = new MaxConnectedAreaAlgo();
        Assert.assertEquals(4, algo.compute(matrix));
    }
}
