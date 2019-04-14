package com.dailyCodingProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//This problem was asked by Facebook.
//
//    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
//
//    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
//
//    You can assume that the messages are decodable. For example, '001' is not allowed.
public class P07 {
  public static final Set<String> encoded = new HashSet<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8",
      "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"));

  public static int getNoOfDecodedWays(String str) {
    if(str.length() == 1) {
      if(encoded.contains(str)) {
        return 1;
      } else {
        return 0;
      }
    } else if(str.length() == 2) {
      if(encoded.contains(str)) {
        return 1 + getNoOfDecodedWays(str.substring(1));
      } else {
        return getNoOfDecodedWays(str.substring(1));
      }
    } else {
      int total = 0;
      if(encoded.contains(str.substring(0, 1))) {
        total += getNoOfDecodedWays(str.substring(1));
      }
      if(encoded.contains(str.substring(0, 2))) {
        total += getNoOfDecodedWays(str.substring(2));
      }
      return total;
    }
  }
}
