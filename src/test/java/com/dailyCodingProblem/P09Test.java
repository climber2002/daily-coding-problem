package com.dailyCodingProblem;

import org.junit.Test;

import static com.dailyCodingProblem.P09.*;
import static org.junit.Assert.assertEquals;

public class P09Test {

  @Test
  public void testGetLargestSumOfAdjacentNumbers() {
    assertEquals(13, getLargestSumOfAdjacentNumbers(new int[] {2, 4, 6, 2, 5}));
    assertEquals(10, getLargestSumOfAdjacentNumbers(new int[] {5, 1, 1, 5}));
  }

  @Test
  public void testGetLargestSumOfAdjacentNumbers2() {
    assertEquals(13, getLargestSumOfAdjacentNumbers2(new int[] {2, 4, 6, 2, 5}));
    assertEquals(10, getLargestSumOfAdjacentNumbers2(new int[] {5, 1, 1, 5}));
  }

  @Test
  public void testGetLargestSumOfAdjacentNumbers3() {
    assertEquals(13, getLargestSumOfAdjacentNumbers3(new int[] {2, 4, 6, 2, 5}));
    assertEquals(10, getLargestSumOfAdjacentNumbers3(new int[] {5, 1, 1, 5}));
  }
}

