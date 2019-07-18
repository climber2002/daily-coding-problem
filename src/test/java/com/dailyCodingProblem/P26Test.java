package com.dailyCodingProblem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class P26Test {

  @Test
  public void testrRemoveLastKth() {
    int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

    P26.Node node = null;
    for(int i = 0; i < arr.length; i++) {
      node = new P26.Node(arr[i], node);
    }

    P26.Node removed = P26.removeLastKth(node, 1);

    ArrayList<Integer> arrList =  removed.toArray();
    Integer[] result = arrList.toArray(new Integer[0]);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9 }, result);
  }
}
