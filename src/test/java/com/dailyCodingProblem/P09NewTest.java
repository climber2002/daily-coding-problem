package com.dailyCodingProblem;

import org.junit.Test;

import static com.dailyCodingProblem.P09New.getLargestSumOfAdjacentNumbers;
import static org.junit.Assert.assertEquals;

public class P09NewTest {
  @Test
  public void testGetLargestSumOfAdjacentNumbers() {
    assertEquals(13, getLargestSumOfAdjacentNumbers(new int[] {2, 4, 6, 2, 5}));
    assertEquals(10, getLargestSumOfAdjacentNumbers(new int[] {5, 1, 1, 5}));
  }
}
