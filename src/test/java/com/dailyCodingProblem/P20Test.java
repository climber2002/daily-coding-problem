package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class P20Test {

  @Test
  public void testGetIntersecting() {
    List<Integer> listA = Arrays.asList(new Integer[] { 3, 7, 8, 10 });
    List<Integer> listB = Arrays.asList(new Integer[] { 99, 1, 8, 10 });

    assertEquals((Integer)8, P20.getIntersecting(listA, listB));

  }
}
