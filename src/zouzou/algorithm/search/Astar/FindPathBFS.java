package zouzou.algorithm.search.Astar;

import java.util.*;

public class FindPathBFS {
    public int execute(char[][] matrix,
                       int startX, int startY,
                       int endX, int endY) {
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);
        startPoint.distFromStart = 0;
        System.out.println("Process from " + startPoint + " to " + endPoint);

        Deque<Point> queue = new ArrayDeque<>();
        Set<Point> crossedPoints = new HashSet<>();

        queue.offer(startPoint);
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            crossedPoints.add(currentPoint);

            if (currentPoint.equals(endPoint)) {
                return currentPoint.distFromStart;
            } else {
                nearestPoints(currentPoint, matrix).stream()
                        .peek(p -> p.distFromStart = currentPoint.distFromStart + 1)
                        .filter(p -> !crossedPoints.contains(p))
                        .forEach(queue::offer);
            }
        }
        throw new RuntimeException("Impossible solution");
    }


    private Set<Point> nearestPoints(Point current, char[][] matrix) {
        int matrixRowNum = matrix.length;
        int matrixColNum = matrix[0].length;

        Set<Point> nearestPoints = new HashSet<>();

        int xNext = current.x + 1;
        while (xNext < matrixRowNum && matrix[xNext][current.y] != 'X') {
            nearestPoints.add(new Point(xNext, current.y));
            xNext++;
        }

        xNext = current.x - 1;
        while (xNext >= 0 && matrix[xNext][current.y] != 'X') {
            nearestPoints.add(new Point(xNext, current.y));
            xNext--;
        }

        int yNext = current.y + 1;
        while (yNext < matrixColNum && matrix[current.x][yNext] != 'X') {
            nearestPoints.add(new Point(current.x, yNext));
            yNext++;
        }

        yNext = current.y - 1;
        while (yNext >= 0 && matrix[current.x][yNext] != 'X') {
            nearestPoints.add(new Point(current.x, yNext));
            yNext--;
        }

        return nearestPoints;
    }

    protected static class Point {
        int x;
        int y;
        int distFromStart = Integer.MAX_VALUE;

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
