package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class P525Test {
  @Test
  public void test() {
    int[] result = P525.getClockWise(new int[][] {
      new int[] {1, 2, 3, 4, 5},
      new int[] {6, 7, 8, 9, 10},
      new int[] {11, 12, 13, 14, 15},
      new int[] {16, 17, 18, 19, 20}
    });

    assertArrayEquals(new int[] {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12}, result);
  }
}
