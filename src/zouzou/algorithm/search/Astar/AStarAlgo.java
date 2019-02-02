package zouzou.algorithm.search.Astar;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AStarAlgo {
    public int initAndExecute(char[][] matrix, Point start, Point end) {
        return execute(matrix, start, end, new HashSet<>());
    }

    public int execute(char[][] matrix,
                       Point start,
                       Point end,
                       Set<Point> crossedPoints) {
        System.out.println("Process from " + start + " to " + end);
        crossedPoints.add(start);

        Set<Point> neighbours = nearestPoint(start, matrix);
        if (neighbours.contains(end)) {
            return 1;
        } else if (neighbours.isEmpty()) {
            throw new RuntimeException("Zouzou you can do better, I trust on you");
        }
        int minHeuristic = Integer.MAX_VALUE;
        Point nextPoint = null;
        for (Point n : neighbours) {
            if(crossedPoints.contains(n)) {
                continue;
            }
            int heuristicVal = heuristicVal(n, end);
            if (heuristicVal < minHeuristic) {
                minHeuristic = heuristicVal;
                nextPoint = n;
            }
        }
        return 1 + execute(matrix, nextPoint, end, crossedPoints);

    }

    private int heuristicVal(Point s, Point n) {
        return Math.abs(s.x - n.x) + Math.abs(s.y - n.y);
    }

    private Set<Point> nearestPoint(Point current, char[][] matrix) {
        int matrixRowNum = matrix.length;
        int matrixColNum = matrix[0].length;

        Set<Point> neighbour = new HashSet<>();
        if (current.x > 0 && matrix[current.x - 1][current.y] != 'X') {
            neighbour.add(new Point(current.x - 1, current.y));
        }
        if (current.y > 0 && matrix[current.x][current.y - 1] != 'X') {
            neighbour.add(new Point(current.x, current.y - 1));
        }
        if (current.x < matrixRowNum - 1 && matrix[current.x + 1][current.y] != 'X') {
            neighbour.add(new Point(current.x + 1, current.y));
        }
        if (current.y < matrixColNum - 1 && matrix[current.x][current.y + 1] != 'X') {
            neighbour.add(new Point(current.x, current.y + 1));
        }

        return neighbour;
    }

    protected static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
