package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P16Test {

  @Test
  public void testGetLast() {
    P16 p16 = new P16();
    p16.record("a");
    p16.record("b");
    p16.record("c");

    assertEquals("c", p16.getLast(0));
    assertEquals("b", p16.getLast(1));
  }
}
