package com.dailyCodingProblem;

//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
//        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//
//        Bonus: Can you do this in one pass?

import java.util.HashSet;
import java.util.Set;

public class P01 {

  public static boolean isAddUpTo(int[] array, int k) {
    Set<Integer> numbers = new HashSet<Integer>();
    for(int i = 0; i < array.length; i++) {
      int n = array[i];
      if(numbers.contains(k - n)) {
        return true;
      }
      numbers.add(n);
    }
    return false;
  }
}
