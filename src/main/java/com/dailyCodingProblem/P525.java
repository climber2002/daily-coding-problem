package com.dailyCodingProblem;

//This problem was asked by Amazon.
//
//  Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
//
//  For example, given the following matrix:
//
//  [[1,  2,  3,  4,  5],
//  [6,  7,  8,  9,  10],
//  [11, 12, 13, 14, 15],
//  [16, 17, 18, 19, 20]]
//  You should print out the following:
//
//  1
//  2
//  3
//  4
//  5
//  10
//  15
//  20
//  19
//  18
//  17
//  16
//  11
//  6
//  7
//  8
//  9
//  14
//  13
//  12
public class P525 {
  static enum Direction {
    EAST, SOUTH, WEST, NORTH
  }

  static class Point {
    public final int row;
    public final int column;

    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  static class PointWithDirection {
    public final Point point;
    public final Direction direction;

    public PointWithDirection(Point point, Direction direction) {
      this.point = point;
      this.direction = direction;
    }
  }

  public static int[] getClockWise(int[][] matrix) {
    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;
    boolean[][] visited = new boolean[totalRows][totalColumns];
    int[] result = new int[totalRows * totalColumns];
    processNumber(matrix, visited, 0, 0, Direction.EAST, totalRows, totalColumns, 0, result);
    return result;
  }

  private static void processNumber(int[][] matrix, boolean[][] visited,
                                    int currentRow, int currentColumn, Direction currentDirection,
                                    int totalRows, int totalColumns,
                                    int currentProcessedCount,
                                    int[] result) {
    result[currentProcessedCount] = matrix[currentRow][currentColumn];
    visited[currentRow][currentColumn] = true;
    if(currentProcessedCount >= totalRows * totalColumns) {
      return;
    }
    PointWithDirection nextPointWithDirection = getNextPointWithDirection(currentRow, currentColumn, currentDirection,
      visited, totalRows, totalColumns);
    if(nextPointWithDirection != null) {
      processNumber(matrix, visited, nextPointWithDirection.point.row, nextPointWithDirection.point.column, nextPointWithDirection.direction,
        totalRows, totalColumns, currentProcessedCount + 1, result);
    }
  }

  private static PointWithDirection getNextPointWithDirection(int currentRow, int currentColumn, Direction currentDirection,
                                                              boolean[][] visited, int totalRows, int totalColumns) {
    int rotationCount = 0;
    Direction nextDirection = currentDirection;
    while(rotationCount < Direction.values().length) {
      Point nextPoint = getNextPoint(currentRow, currentColumn, nextDirection);
      if(isValid(nextPoint.row, nextPoint.column, totalRows, totalColumns) && !visited[nextPoint.row][nextPoint.column]) {
        return new PointWithDirection(nextPoint, nextDirection);
      } else {
        nextDirection = getNextDirection(nextDirection);
      }
      rotationCount++;
    }
    return null;
  }

  private static Point getNextPoint(int currentRow, int currentColumn, Direction currentDirection) {
    if(currentDirection == Direction.EAST) {
      return new Point(currentRow, currentColumn + 1);
    } else if(currentDirection == Direction.SOUTH) {
      return new Point(currentRow + 1, currentColumn);
    } else if(currentDirection == Direction.WEST) {
      return new Point(currentRow, currentColumn - 1);
    } else if(currentDirection == Direction.NORTH) {
      return new Point(currentRow - 1, currentColumn);
    } else {
      return null;
    }
  }

  private static Direction getNextDirection(Direction direction) {
    return Direction.values()[(direction.ordinal() + 1) % Direction.values().length];
  }

  private static boolean isValid(int row, int column, int totalRows, int totalColumns) {
    return row >= 0 && row < totalRows && column >= 0 && column < totalColumns;
  }
}
