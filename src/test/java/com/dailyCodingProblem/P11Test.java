package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class P11Test {

  @Test
  public void testGetStringsWithPrefix() {
    assertArrayEquals(new String[] {"deer", "deal"},
        P11.getStringsWithPrefix("de", new String[] {"dog", "deer", "deal"}));
  }
}
