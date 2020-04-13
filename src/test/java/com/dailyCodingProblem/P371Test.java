package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P371Test {

  @Test
  public void testExpression() {
    P371.Expression exp = new P371.Expression("y = x + 1");
    assertEquals(-1, exp.getConstant());
    assertEquals(2, exp.getVariables().size());
    assertEquals(true, exp.getVariables().get("y").isPositive());
    assertEquals(false, exp.getVariables().get("x").isPositive());
  }
}
