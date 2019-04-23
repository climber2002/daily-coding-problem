package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P13Test {

  @Test
  public void testGetLongestLength() {
    assertEquals(3, P13.getLongestLength(2, "abcba"));

    assertEquals(4, P13.getLongestLength(2, "abbacc"));
  }

  @Test
  public void testGetLongestLength2() {
    assertEquals(3, P13.getLongestLength2(2, "abcba"));

    assertEquals(4, P13.getLongestLength2(2, "abbacc"));
  }
}
