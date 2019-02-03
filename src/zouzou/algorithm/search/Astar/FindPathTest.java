package zouzou.algorithm.search.Astar;

import org.junit.Assert;
import org.junit.Test;

public class FindPathTest {
    @Test
    public void execute_site_test_withAStar() {
        FindPathAStar aStarAlgo = new FindPathAStar();
        char[][] matrix = new char[][]{{'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void execute_site_test_With_2_X_withAStar() {
        FindPathAStar aStarAlgo = new FindPathAStar();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void execute_site_test_With_2_X_SEPARETED_withAStar() {
        FindPathAStar aStarAlgo = new FindPathAStar();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = aStarAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void execute_site_test_withBFS() {
        FindPathBFS bfsAlgo = new FindPathBFS();
        char[][] matrix = new char[][]{{'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = bfsAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(1, result);
    }

    @Test
    public void execute_site_test_With_2_X_withBFS() {
        FindPathBFS bfsAlgo = new FindPathBFS();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = bfsAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void execute_site_test_With_2_X_SEPARETED_withBFS() {
        FindPathBFS bfsAlgo = new FindPathBFS();
        char[][] matrix = new char[][]{{'.', 'X', '.'}, {'.', '.', '.'}, {'.', 'X', '.'}, {'.', '.', '.'}};
        int result = bfsAlgo.execute(matrix, 0, 0, 0, 2);
        Assert.assertEquals(3, result);
    }
}