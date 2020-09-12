package javaCodingInterview;

import java.util.Objects;
import java.util.Set;

//Problem: We have an m x n grid. A robot is placed at the top-left corner of this grid.
// The robot can only move either right or down at any point in time, but it is not
// allowed to move in certain cells. The robot's goal is to find a path from the
// top-left corner to the bottom-right corner of the grid.grid
public class RobotGrid {

  static class Point {
    public final int x;
    public final int y;

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
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {
    if (m < 0 || n < 0) {
      return false;
    }

    if(maze[m][n]) {
      return false;
    }

    if(m == 0 && n == 0) {
      return true;
    }

    Point p = new Point(m, n);
    path.add(p);

    if (((m == 0) && (n == 0))
      || computePath(m, n - 1, maze, path)
      || computePath(m - 1, n, maze, path)) {
      path.add(new Point(m, n));
      return true;
    }

    return false;
  }

}
