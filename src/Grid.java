public class Grid {
    private int[][] matrix;

    public Grid(int numRow, int numColumn) {
        matrix = new int[numRow][numColumn];
    }

    public void setCellValue(int val, int row, int column) {
        matrix[row][column] = val;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void displayGrid() {
        for (int[] row : matrix) {
            StringBuilder rowBuilder = new StringBuilder("|");
            for (int cell : row) {
                rowBuilder.append(" ").append(cell).append(" |");
            }
            System.out.println(rowBuilder.toString());
        }
    }
}
