package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P04Test {

  @Test
  public void testLowestPositiveIntegerNotExist() {
    assertEquals(P04.lowestPositiveIntegerNotExist(new int[] {3, 4, -1, 1}), 2);

    assertEquals(P04.lowestPositiveIntegerNotExist(new int[] {1, 2, 0}), 3);
  }
}
