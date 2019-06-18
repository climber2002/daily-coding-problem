package com.dailyCodingProblem;

import java.util.*;

//This problem was asked by Google.
//
//    You are given an M by N matrix consisting of booleans that represents a board. Each True boolean
//    represents a wall. Each False boolean represents a tile you can walk on.
//
//    Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps
//    required to reach the end coordinate from the start. If there is no possible path, then return null.
//    You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
//
//    For example, given the following board:
//
//    [[f, f, f, f],
//    [t, t, f, t],
//    [f, f, f, f],
//    [f, f, f, f]]
//    and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required
//    to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere
//    else on the second row.
public class P23 {

  public static class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {

      // If the object is compared with itself then return true
      if (o == this) {
        return true;
      }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
      if (!(o instanceof Point)) {
        return false;
      }

      // typecast o to Complex so that we can compare data members
      Point p = (Point) o;

      // Compare the data members and return accordingly
      return p.x == this.x && p.y == this.y;
    }
  }

  static class PointNode {
    public final Point point;
    public final int distance;

    public PointNode(Point point, int distance) {
      this.point = point;
      this.distance = distance;
    }
  }

  public static Integer getShortestSteps(boolean[][] matrix, Point start, Point end) {
    Queue<PointNode> queue = new LinkedList<>();
    queue.add(new PointNode(start, 0));

    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    while(!queue.isEmpty()) {
      PointNode node = queue.remove();
      if(node.point.equals(end)) {
        return node.distance;
      }

      processNeighbourPoints(matrix, queue, visited, node);
    }
    return null;
  }

  private static void processNeighbourPoints(boolean[][] matrix, Queue<PointNode> queue, boolean[][] visited, PointNode currentNode) {
    Point currentPoint = currentNode.point;
    int currentDistance = currentNode.distance;

    Point leftPoint = new Point(currentPoint.x - 1, currentPoint.y);
    processNeighbourPoint(matrix, queue, visited, leftPoint, currentDistance);
    Point rightPoint = new Point(currentPoint.x + 1, currentPoint.y);
    processNeighbourPoint(matrix, queue, visited, rightPoint, currentDistance);
    Point upPoint = new Point(currentPoint.x, currentPoint.y + 1);
    processNeighbourPoint(matrix, queue, visited, upPoint, currentDistance);

    Point downPoint = new Point(currentPoint.x, currentPoint.y - 1);
    processNeighbourPoint(matrix, queue, visited, downPoint, currentDistance);
  }

  private static void processNeighbourPoint(boolean[][] matrix, Queue<PointNode> queue, boolean[][] visited, Point neighbourPoint, int currentDistance) {
    if(canWalkOn(matrix, neighbourPoint) && !visited[neighbourPoint.x][neighbourPoint.y]) {
      visited[neighbourPoint.x][neighbourPoint.y] = true;
      queue.add(new PointNode(neighbourPoint, currentDistance + 1));
    }
  }


  private static boolean canWalkOn(boolean[][] matrix, Point point) {
    return (point.x >= 0) && (point.x < matrix[0].length) && (point.y >= 0) && (point.y < matrix.length) && !matrix[point.x][point.y];
  }
}
