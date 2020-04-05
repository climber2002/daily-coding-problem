package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class P361Test {

  @Test
  public void testCombination_1() {
    List<List<Integer>> result = P361.combinations(new Integer[] {1, 2, 3, 4}, 1);
    System.out.println(Arrays.toString(result.toArray()));
    assertEquals(4, result.size());
  }

  @Test
  public void testCombination_2() {
    List<List<Integer>> result = P361.combinations(new Integer[] {1, 2, 3, 4}, 2);
    System.out.println(Arrays.toString(result.toArray()));
    assertEquals(6, result.size());
  }
}
