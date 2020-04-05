package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class P362Test {

  @Test
  public void testGetAllStrobogrammaticNumbersForEven_1digit() {
    List<Integer> result = P362.getAllStrobogrammaticNumbersForEvenHalfed(1);
    assertArrayEquals(new Integer[] { 0, 1, 6, 8, 9 }, result.toArray(new Integer[0]));
  }

  @Test
  public void testGetAllStrobogrammaticNumbersForEven_2digits() {
    List<Integer> result = P362.getAllStrobogrammaticNumbersForEvenHalfed(2);
    System.out.println(Arrays.toString(result.toArray()));
    assertArrayEquals(new Integer[] { 10, 60, 80, 90, 11, 61, 81, 91, 16, 66, 86, 96, 18, 68, 88, 98, 19, 69, 89, 99 },
      result.toArray(new Integer[0]));
  }

  @Test
  public void testGetAllStrobogrammaticNumbersForOddHalfed_1digit() {
    List<Integer> result = P362.getAllStrobogrammaticNumbersForOddHalfed(1);
    System.out.println(Arrays.toString(result.toArray()));
    assertArrayEquals(new Integer[] { 1, 8 }, result.toArray(new Integer[0]));
  }

  @Test
  public void testGetAllStrobogrammaticNumbersForOddHalfed_3digits() {
    List<Integer> result = P362.getAllStrobogrammaticNumbersForOddHalfed(3);
    System.out.println(Arrays.toString(result.toArray()));
    assertArrayEquals(new Integer[] { 100, 101, 108, 600, 601, 608, 800, 801, 808,
      900, 901, 908, 110, 111, 118, 610, 611, 618, 810, 811, 818, 910, 911, 918, 160,
      161, 168, 660, 661, 668, 860, 861, 868, 960, 961, 968, 180, 181, 188, 680, 681,
      688, 880, 881, 888, 980, 981, 988, 190, 191, 198, 690, 691, 698, 890, 891, 898,
      990, 991, 998 }, result.toArray(new Integer[0]));
  }

  @Test
  public void testGetStrobogrammaticNumbersFromEvenHalfed() {
    assertEquals(1881, (int)P362.getStrobogrammaticNumbersFromEvenHalfed(18, 2));
    assertEquals(6009, (int)P362.getStrobogrammaticNumbersFromEvenHalfed(60, 2));
  }

  @Test
  public void testGetStrobogrammaticNumbersFromOddHalfed() {
    assertEquals(18181, (int)P362.getStrobogrammaticNumbersFromOddHalfed(181, 3));
    assertEquals(98186, (int)P362.getStrobogrammaticNumbersFromOddHalfed(981, 3));
  }

  @Test
  public void testGetDigits() {
    assertArrayEquals(new Integer[] { 2, 1 }, P362.getDigits(21));
  }

  @Test
  public void testGetAllStrobogrammaticNumbers() {
    Integer[] result = P362.getAllStrobogrammaticNumbers(4);
    System.out.println(Arrays.toString(result));
  }
}
