package com.dailyCodingProblem;

public class P372 {

  public static int numberOfDigits(int num) {
    if(num == 0) {
      return 1;
    }
    return numberOfDigitsForPositive(num);
  }

  private static int numberOfDigitsForPositive(int num) {
    if(num == 0) {
      return 0;
    }
    return 1 + numberOfDigitsForPositive(num / 10);
  }
}
