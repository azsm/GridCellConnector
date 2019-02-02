package zouzou.algorithm.search.Astar;

import java.util.*;

public class AStarAlgo {


    public int execute(char[][] matrix,
                        int startX, int startY,
                        int endX, int endY) {
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);
        startPoint.distFromStart = 0;
        startPoint.heuresticDistToEnd = heuristicVal(startPoint, endPoint);
        System.out.println("Process from " + startPoint + " to " + endPoint);

        PriorityQueue<Point> priorityQueue = new PriorityQueue<>((o1, o2) ->
                o1.distFromStart + o1.heuresticDistToEnd
                        - o2.distFromStart - o2.heuresticDistToEnd);
        Map<Point, Integer> crossedPoints = new HashMap<>();

        priorityQueue.offer(startPoint);
        while(!priorityQueue.isEmpty()) {
            Point currentPoint = priorityQueue.poll();
            crossedPoints.put(currentPoint, currentPoint.getEstimatedDistance());

            if(currentPoint.heuresticDistToEnd == 0) {
                return currentPoint.distFromStart;
            }
            else {
                nearestPoints(currentPoint, matrix).stream()
                        .peek(p -> {
                            p.distFromStart = currentPoint.distFromStart + 1;
                            p.heuresticDistToEnd = heuristicVal(p, endPoint);
                        })
                        .filter(p -> !crossedPoints.containsKey(p) ||
                                crossedPoints.get(p) > p.getEstimatedDistance())
                        .forEach(priorityQueue::offer);
            }
        }
        throw new RuntimeException("Impossible solution");
    }

    private int heuristicVal(Point s, Point n) {
        return (Math.abs(s.x - n.x) > 0 ? 1 : 0)
                + (Math.abs(s.y - n.y) > 0 ? 1 : 0);
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
        int heuresticDistToEnd = Integer.MAX_VALUE;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getEstimatedDistance() {
            return distFromStart + heuresticDistToEnd;
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
