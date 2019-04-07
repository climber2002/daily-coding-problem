package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P01Test {

  @Test
  public void testP01_addUpTo() {
    assertEquals(P01.isAddUpTo(new int[] { 10, 15, 3, 7}, 17), true);
  }

  @Test
  public void testP01_notAddUpTo() {
    assertEquals(P01.isAddUpTo(new int[] { 10, 15, 3, 8}, 17), false);
  }
}
