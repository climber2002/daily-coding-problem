package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P357Test {

  @Test
  public void testOnlyRoot() {
    P357.Node root = P357.parseTree("(00)");
    assertEquals(1, P357.getDepth(root));
  }

  @Test
  public void testOneChild() {
    assertEquals(2, P357.getDepth(P357.parseTree("((00)(00))")));
  }

  @Test
  public void testUnbalancedLeftTree() {
    assertEquals(4, P357.getDepth(P357.parseTree("((((00)0)0)0)")));
  }
  @Test
  public void testUnbalancedLeftTree_2() {
    assertEquals(4, P357.getDepth("((((00)0)0)0)"));
  }

}
