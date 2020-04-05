package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class P362AnswerTest {

  @Test
  public void testConvertToInt() {
    assertEquals(108801, (int)P362Answer.convertToInt(Arrays.asList(1, 0, 8), true));
    assertEquals(96196, (int)P362Answer.convertToInt(Arrays.asList(9, 6, 1), false));
  }

  @Test
  public void testGetStrobogrammaticNumbers_odd() {
    Set<Integer> result = P362Answer.getStrobogrammaticNumbers(3);
    System.out.println(Arrays.toString(result.toArray(new Integer[0])));
    assertEquals(new HashSet<>(Arrays.asList(609, 689, 818, 916, 101, 181, 808, 888, 906, 986, 619, 111)), result);
  }

  @Test
  public void testGetStrobogrammaticNumbers_even() {
    Set<Integer> result = P362Answer.getStrobogrammaticNumbers(4);
    System.out.println(Arrays.toString(result.toArray(new Integer[0])));
    assertEquals(
      new HashSet<>(Arrays.asList(9696, 6119, 8968, 8008, 1961, 1001, 6889, 6699, 9966,
        9006, 8118, 1111, 8888, 1881, 6969, 6009, 8698, 1691, 9116, 9886)), result);
  }
}
