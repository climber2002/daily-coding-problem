package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class P18Test {

  @Test
  public void testGetMaxOfSubArray() {
    assertArrayEquals(new int[] {10, 7, 8, 8},  P18.getMaxOfSubArray(new int[] {10, 5, 2, 7, 8, 7}, 3));
  }
}
