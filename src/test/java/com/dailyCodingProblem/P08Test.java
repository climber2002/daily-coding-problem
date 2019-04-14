package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P08Test {
  //  For example, the following tree has 5 unival subtrees:
  //
  //      0
  //      / \
  //      1   0
  //          / \
  //          1   0
  //          / \
  //          1   1
  @Test
  public void testGetNoOfUnivalSubtrees() {
    P08.Node node =
        new  P08.Node(0,
                  new P08.Node(1),
                  new P08.Node(0,
                                new P08.Node(1, new P08.Node(1), new P08.Node(1)),
                                new P08.Node(0)));
    assertEquals(5, P08.getNoOfUnivalSubtrees(node));
  }
}
