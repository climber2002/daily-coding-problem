package com.dailyCodingProblem;

//This problem was asked by Stripe.
//
//    Given an array of integers, find the first missing positive integer in linear time and constant space.
//    In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//
//    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
//
//    You can modify the input array in-place.

public class P04 {

  public static int lowestPositiveIntegerNotExist(int[] numbers) {
    boolean[] flags = new boolean[numbers.length];

    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] >= 0 && numbers[i] < numbers.length) {
        flags[numbers[i]] = true;
      }
    }

    for(int i = 1; i < numbers.length; i++) {
      if(!flags[i]) {
        return i;
      }
    }
    return numbers.length;
  }
}
