package com.dailyCodingProblem;


import java.util.HashMap;
import java.util.Map;

//This problem was asked by Amazon.
//
//    Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
//
//    For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
public class P13 {

  public static int getLongestLength(int k, String s) {
    int maxLen = 0;
    int start = 0;
    int end = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        int freq = map.get(c);
        map.put(c, freq + 1);
      } else {
        map.put(c, 1);
      }

      if (map.size() > k) {
        maxLen = Math.max(maxLen, end - start);

        // Shrink the window size
        while (map.size() > k) {
          char startC = s.charAt(start);
          int freq = map.get(startC);
          if (freq == 1) {
            map.remove(startC);
          } else {
            map.put(startC, freq - 1);
          }
          start++;
        }
      }
    }

    if (start < s.length()) {
      maxLen = Math.max(maxLen, end - start);
    }

    return maxLen;
  }

  public static int getLongestLength2(int k, String s) {
    int maxLen = 0;
    int start = 0;
    int end = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    while(end < s.length()) {
      if(map.size() <= k) {
        char c = s.charAt(end);
        if (map.containsKey(c)) {
          int freq = map.get(c);
          map.put(c, freq + 1);
        } else {
          map.put(c, 1);
        }
        end++;
      }

      if(map.size() == k) {
        maxLen = Math.max(end - start, maxLen);
      }

      while(map.size() > k) {
        char startC = s.charAt(start);
        int freq = map.get(startC);
        if (freq == 1) {
          map.remove(startC);
        } else {
          map.put(startC, freq - 1);
        }
        start++;
      }

    }
    return maxLen;
  }
}
