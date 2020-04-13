package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P372Test {

  @Test
  public void testNumberOfDigits() {
    assertEquals(1, P372.numberOfDigits(0));
    assertEquals(1, P372.numberOfDigits(5));
    assertEquals(2, P372.numberOfDigits(10));
    assertEquals(3, P372.numberOfDigits(111));
  }
}
