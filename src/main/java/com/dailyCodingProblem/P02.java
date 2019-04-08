package com.dailyCodingProblem;

//Good morning! Here's your coding interview problem for today.
//
//    This problem was asked by Uber.
//
//    Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers
//    in the original array except the one at i.
//
//    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
//    If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//    Follow-up: what if you can't use division?
public class P02 {
  public static int[] productOtherThanMyself(int[] numbers) {
    int product = 1;
    for(int i = 0; i < numbers.length; i++) {
      product = product * numbers[i];
    }
    int[] result = new int[numbers.length];
    for(int i = 0;  i < result.length; i++) {
      result[i] = product / numbers[i];
    }
    return result;
  }

  public static int[] productOtherThanMyself_withoutDivision(int[] numbers) {
    int[] left = new int[numbers.length];
    int[] right = new int[numbers.length];
    int[] prod = new int[numbers.length];

    for(int i = 0; i < numbers.length; i++) {
      left[i] = 1;
      right[i] = 1;
    }

    for(int i = 1; i < numbers.length; i++) {
      left[i] = numbers[i - 1] * left[i - 1];
    }
    for (int j = numbers.length - 2; j >= 0; j--) {
      right[j] = numbers[j + 1] * right[j + 1];
    }


    for (int i = 0; i < numbers.length; i++) {
      prod[i] = left[i] * right[i];
    }

    return prod;
  }
}
