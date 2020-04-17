package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class P376Test {

  @Test
  public void testGetNearestCoinPosition() {
    P376.Position currentPosition = new P376.Position(0, 2);
    Set<P376.Position> coinPositions = new HashSet<>(Arrays.asList(
      new P376.Position(0, 4),
      new P376.Position(1, 0),
      new P376.Position(2, 0),
      new P376.Position(3, 2)
    ));
    assertEquals(new P376.Position(0, 4), P376.getNearestCoinPosition(currentPosition, coinPositions));
  }
}
