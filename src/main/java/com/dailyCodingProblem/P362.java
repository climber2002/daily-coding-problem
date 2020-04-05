package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * This problem was asked by Twitter.
 *
 * A strobogrammatic number is a positive number that appears the same after being rotated 180 degrees.
 * For example, 16891 is strobogrammatic.
 *
 * Create a program that finds all strobogrammatic numbers with N digits.
 */
public class P362 {

  public static Integer[] noChangeDigits = new Integer[] { 0, 1, 8 };
  public static Integer[] changeDigits = new Integer[] { 6, 9 };
  public static Integer[] allDigits = new Integer[] { 0, 1, 6, 8, 9 };

  public static Integer[] getAllStrobogrammaticNumbers(int digits) {

    List<Integer> result = new ArrayList<>();
    for(int i = 2; i <= digits; i++) {
      final int half = i / 2;
      if(i % 2 == 0) {
        result.addAll(getAllStrobogrammaticNumbersForEvenHalfed(half).stream()
          .map(n -> getStrobogrammaticNumbersFromEvenHalfed(n, half)).collect(Collectors.toList()));
      } else {
        result.addAll(getAllStrobogrammaticNumbersForOddHalfed(half).stream()
          .map(n -> getStrobogrammaticNumbersFromOddHalfed(n, half)).collect(Collectors.toList()));
      }
    }
    return result.toArray(new Integer[0]);
  }

  public static List<Integer> getAllStrobogrammaticNumbersForOddHalfed(int halfDigits) {
    if(halfDigits == 1) {
      return new ArrayList<>(Arrays.asList(noChangeDigits).stream().filter(n -> n > 0).collect(Collectors.toList()));
    }

    List<Integer> result = getAllStrobogrammaticNumbersForEvenHalfed(halfDigits - 1);
    return result.stream().flatMap(number -> Arrays.asList(noChangeDigits).stream().map(digit -> number * 10 + digit))
                 .filter(number -> number >= (int)Math.pow(10, halfDigits - 1) && number > 0)
                 .collect(Collectors.toList());
  }

  public static List<Integer> getAllStrobogrammaticNumbersForEvenHalfed(int halfDigits) {
    if(halfDigits == 1) {
      return new ArrayList<>(Arrays.asList(allDigits));
    }
    List<Integer> result = new ArrayList<>();
    return getAllStrobogrammaticNumbersForEvenHalfed(halfDigits - 1).stream().flatMap(
      number -> Arrays.asList(allDigits).stream().map(digit -> digit * (int)Math.pow(10, halfDigits - 1) + number))
      .filter(number -> number >= (int)Math.pow(10, halfDigits - 1))
      .collect(Collectors.toList());
  }

  public static Integer getStrobogrammaticNumbersFromEvenHalfed(Integer halfed, int halfDigits) {
    int result = halfed * (int)Math.pow(10, halfDigits);
    Integer[] digits = getDigits(halfed);
    for(int i = 0; i < digits.length; i++) {
      result += getStrobogrammaticDigit(digits[i]) * (int)Math.pow(10, i);
    }
    return result;
  }

  public static Integer getStrobogrammaticNumbersFromOddHalfed(Integer halfed, int halfDigits) {
    int result = halfed * (int)Math.pow(10, halfDigits - 1);
    Integer[] digits = getDigits(halfed);
    for(int i = 0; i < digits.length - 1; i++) {
      result += getStrobogrammaticDigit(digits[i]) * (int)Math.pow(10, i);
    }
    return result;
  }

  public static int getStrobogrammaticDigit(int digit) {
    if(digit == 1) {
      return 1;
    } else if(digit == 0) {
      return 0;
    } else if(digit == 8) {
      return 8;
    } else if(digit == 6) {
      return 9;
    } else if(digit == 9) {
      return 6;
    } else {
      throw new IllegalArgumentException("Can't Strobogrammatic for " + digit);
    }
  }

  public static Integer[] getDigits(Integer n) {
    Stack<Integer> stack = new Stack<>();
    int i = n;
    while(i != 0) {
      stack.push(i % 10);
      i = i / 10;
    }
    List<Integer> list = new ArrayList<>();
    while(!stack.isEmpty()) {
      list.add(stack.pop());
    }
    return list.toArray(new Integer[0]);
  }
}
