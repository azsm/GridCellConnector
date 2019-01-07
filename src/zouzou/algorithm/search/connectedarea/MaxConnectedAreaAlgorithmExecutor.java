package zouzou.algorithm.search.connectedarea;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxConnectedAreaAlgorithmExecutor {
    Deque<Cell> neighbourStack = new ArrayDeque<>();

    public int compute(int[][] matrix) {
        int maxAreaSize = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 1) {
                    int areaSize = computeAreaSize(matrix, r, c);
                    maxAreaSize = maxAreaSize < areaSize ? areaSize : maxAreaSize;
                }
            }
        }

        return maxAreaSize;
    }

    private int computeAreaSize(int[][] matrix, int r, int c) {
        int areaSize = 0;

        neighbourStack.push(new Cell(r, c));
        while (!neighbourStack.isEmpty()) {
            areaSize++;

            Cell currentCell = neighbourStack.pop();
            int currentRow = currentCell.r;
            int currentCol = currentCell.c;
            if(currentRow + 1 < matrix.length && matrix[currentRow + 1][currentCol] == 1) {
                neighbourStack.push(new Cell(currentRow + 1, currentCol));
            }
            if(currentRow - 1 > 0 && matrix[currentRow - 1][currentCol] == 1) {
                neighbourStack.push(new Cell(currentRow - 1, currentCol));
            }
            if(currentCol + 1 < matrix[0].length && matrix[currentRow][currentCol + 1] == 1) {
                neighbourStack.push(new Cell(currentRow, currentCol + 1));
            }
            if(currentCol - 1 > 0 && matrix[currentRow][currentCol - 1] == 1) {
                neighbourStack.push(new Cell(currentRow, currentCol - 1));
            }
            matrix[currentRow][currentCol] = 0;
        }
        return areaSize;
    }

    private static class Cell {
        int r;
        int c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
