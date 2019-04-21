package com.dailyCodingProblem;

import org.junit.Test;
import static com.dailyCodingProblem.P12.getNoOfUniqueWays;
import static org.junit.Assert.assertEquals;

public class P12Test {

  @Test
  public void testGetNoOfUniqueWays() {
    assertEquals(5, getNoOfUniqueWays(4));
  }
}
