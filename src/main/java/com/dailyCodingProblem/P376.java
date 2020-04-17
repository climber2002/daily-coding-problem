package com.dailyCodingProblem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This problem was asked by Google.
 *
 * You are writing an AI for a 2D map game. You are somewhere in a 2D grid, and there are coins strewn about
 * over the map.
 *
 * Given the position of all the coins and your current position, find the closest coin to you in terms of
 * Manhattan distance. That is, you can move around up, down, left, and right, but not diagonally.
 * If there are multiple possible closest coins, return any of them.
 *
 * For example, given the following map, where you are x, coins are o, and empty spaces are . (top left is 0, 0):
 *
 * ---------------------
 * | . | . | x | . | o |
 * ---------------------
 * | o | . | . | . | . |
 * ---------------------
 * | o | . | . | . | o |
 * ---------------------
 * | . | . | o | . | . |
 * ---------------------
 * return (0, 4), since that coin is closest. This map would be represented in our question as:
 *
 * Our position: (0, 2)
 * Coins: [(0, 4), (1, 0), (2, 0), (3, 2)]
 */
public class P376 {
  public static final int MAP_SIZE = 5;

  public static class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Position leftPosition() {
      int newX = this.x - 1;
      if(newX < 0) {
        return null;
      } else {
        return new Position(newX, y);
      }
    }

    public Position rightPosition() {
      int newX = this.x + 1;
      if(newX >= MAP_SIZE) {
        return null;
      } else {
        return new Position(newX, y);
      }
    }

    public Position upPosition() {
      int newY = this.y - 1;
      if(newY < 0) {
        return null;
      } else {
        return new Position(x, newY);
      }
    }

    public Position downPosition() {
      int newY = this.y + 1;
      if(newY >= MAP_SIZE) {
        return null;
      } else {
        return new Position(x, newY);
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Position position = (Position) o;
      return x == position.x &&
        y == position.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public static Position getNearestCoinPosition(Position currentPosition, Set<Position> coinPositions) {
    Set<Position> visited = new HashSet<>();
    visited.add(currentPosition);

    Queue<Position> queue = new LinkedList<>();
    queue.add(currentPosition);

    while(!queue.isEmpty()) {
      Position position = queue.poll();
      List<Position> neighbourPositions = Arrays.asList(position.leftPosition(), position.upPosition(),
        position.rightPosition(), position.downPosition()).stream().filter(p -> p != null).collect(Collectors.toList());

      for(Position neighbour : neighbourPositions) {
        if(!visited.contains(neighbour)) {
          if(coinPositions.contains(neighbour)) {
            return neighbour;
          } else {
            visited.add(neighbour);
            queue.add(neighbour);
          }
        }
      }
    }
    return null;
  }
}
