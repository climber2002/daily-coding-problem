package com.dailyCodingProblem;

import java.util.Arrays;

import static java.lang.Math.max;

//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
//    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
//    Follow-up: Can you do this in O(N) time and constant space?
public class P09 {

  public static int getLargestSumOfAdjacentNumbers(int[] numbers) {
    if(numbers.length == 1) {
      return numbers[0];
    }
    if(numbers.length == 2) {
      return max(numbers[0], numbers[1]);
    }

    return max(getLargestSumOfAdjacentNumbers(Arrays.copyOfRange(numbers, 0, numbers.length - 2)) + numbers[numbers.length - 1],
        getLargestSumOfAdjacentNumbers(Arrays.copyOfRange(numbers, 0, numbers.length - 1)));
  }

  public static int getLargestSumOfAdjacentNumbers2(int[] numbers) {
    int inc = numbers[0];
    int exl = 0;
    for(int i = 1; i < numbers.length; i++) {
      int oldInc = inc;
      inc = max(exl + numbers[i], inc);
      exl = max(oldInc, exl);
    }
    return max(inc, exl);
  }

  public static int getLargestSumOfAdjacentNumbers3(int[] numbers) {
    int prevOne = 0;
    int prevTwo = 0;
    int res = 0;
    for(int i = 0; i < numbers.length; i++) {
      if(i == 0) {
        res = numbers[0];
      }else if(i == 1) {
        res = max(numbers[0], numbers[1]);
      } else {
        res = max(prevTwo + numbers[i], prevOne);
      }

      prevTwo = prevOne;
      prevOne = res;
    }

    return res;
  }
}
