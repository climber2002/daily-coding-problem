package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class P02Test {

  @Test
  public void testProductOtherThanMyself() {
    assertArrayEquals(P02.productOtherThanMyself(new int[] { 1, 2, 3, 4, 5 }), new int[] {120, 60, 40, 30, 24});
  }

  @Test
  public void testProductOtherThanMyself2() {
    assertArrayEquals(P02.productOtherThanMyself_withoutDivision(new int[] { 1, 2, 3, 4, 5 }), new int[] {120, 60, 40, 30, 24});
  }
}
