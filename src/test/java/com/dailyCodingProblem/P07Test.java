package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P07Test {

  @Test
  public void testGetNoOfDecodedWays() {
    assertEquals(1, P07.getNoOfDecodedWays("1"));
    assertEquals(2, P07.getNoOfDecodedWays("11"));

    assertEquals(3, P07.getNoOfDecodedWays("111"));

    assertEquals(5, P07.getNoOfDecodedWays("1111"));
  }

}
