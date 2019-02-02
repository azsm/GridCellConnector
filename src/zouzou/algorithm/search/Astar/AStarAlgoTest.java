package zouzou.algorithm.search.Astar;

import org.junit.Assert;
import org.junit.Test;

public class AStarAlgoTest {
    @Test
    public void execute_site_test() {
        AStarAlgo aStarAlgo = new AStarAlgo();
        char[][] matrix = new char[][]{{'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.initAndExecute(matrix, new AStarAlgo.Point(0, 0), new AStarAlgo.Point(0, 2));
        Assert.assertEquals(2, result);
    }

    @Test
    public void execute_site_test_With_2_X() {
        AStarAlgo aStarAlgo = new AStarAlgo();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.initAndExecute(matrix, new AStarAlgo.Point(0, 0), new AStarAlgo.Point(0, 2));
        Assert.assertEquals(6, result);
    }

    @Test
    public void execute_site_test_With_2_X_SEPARETED() {
        AStarAlgo aStarAlgo = new AStarAlgo();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.initAndExecute(matrix, new AStarAlgo.Point(0, 0), new AStarAlgo.Point(0, 2));
        Assert.assertEquals(4, result);
    }
}