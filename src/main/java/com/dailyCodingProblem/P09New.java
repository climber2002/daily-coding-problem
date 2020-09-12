package com.dailyCodingProblem;

import java.util.Arrays;

import static java.lang.Math.max;

public class P09New {
  public static int getLargestSumOfAdjacentNumbers(int[] numbers) {
    return helper(numbers, 0);
  }

  private static int helper(int[] numbers, int currentIndex) {
    if(currentIndex >= numbers.length) {
      return 0;
    }
    if(numbers[currentIndex] < 0) {
      return max(helper(numbers, currentIndex + 1), helper(numbers, currentIndex + 2));
    } else {
      return max(numbers[currentIndex] + helper(numbers, currentIndex + 2),
        helper(numbers, currentIndex + 1));
    }
  }
}
