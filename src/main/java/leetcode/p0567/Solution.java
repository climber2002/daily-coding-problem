package leetcode.p0567;

import java.util.*;

class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if(s1.isEmpty()) {
      return true;
    }

    if(s1.length() > s2.length()) {
      return false;
    }

    Map<Character, Integer> s1Frequencies = new HashMap<>();
    for(char c : s1.toCharArray()) {
      s1Frequencies.put(c, s1Frequencies.getOrDefault(c, 0) + 1);
    }

    int left = 0;
    int right = 0;
    char[] chars = s2.toCharArray();
    int formed = 0;
    Map<Character, Integer> windowMap = new HashMap<>();
    while(right < chars.length) {
      char c = chars[right++];
      if(s1Frequencies.containsKey(c)) {
        windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        if(windowMap.get(c).intValue() == s1Frequencies.get(c).intValue()) {
          formed++;
        }
      }

      while(left <= right && formed == s1Frequencies.size()) {
        if(right - left == s1.length()) {
          return true;
        }

        char cLeft = chars[left++];
        if(s1Frequencies.containsKey(cLeft)) {
          if(windowMap.get(cLeft).intValue() == s1Frequencies.get(cLeft).intValue()) {
            formed--;
          }
          windowMap.put(cLeft, windowMap.get(cLeft) - 1);
        }
      }
    }

    return false;
  }
}
