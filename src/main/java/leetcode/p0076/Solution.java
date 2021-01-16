package leetcode.p0076;

import java.util.*;

public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, Integer> mapT = new HashMap<>();
    for(char c : t.toCharArray()) {
      int count = mapT.getOrDefault(c, 0);
      mapT.put(c, count + 1);
    }

    int minLength = Integer.MAX_VALUE;
    int start = -1;

    int windowFront = 0;
    int windowEnd = 0;
    Map<Character, Integer> windowMap = new HashMap<>();
    int formed = 0;

    char[] chars = s.toCharArray();
    while(windowFront < chars.length) {
      char c = chars[windowFront];
      windowFront++;

      int count = windowMap.getOrDefault(c, 0);
      windowMap.put(c, count + 1);
      if(mapT.containsKey(c) && mapT.get(c) == windowMap.get(c)) {
        formed++;
      }

      while(windowEnd <= windowFront && formed == mapT.size()) {
        if(minLength > windowFront - windowEnd) {
          minLength = windowFront - windowEnd;
          start = windowEnd;
        }

        char c2 = chars[windowEnd];

        if(mapT.containsKey(c2) && windowMap.get(c2) == mapT.get(c2)) {
          formed--;
        }
        windowMap.put(c2, windowMap.get(c2) - 1);

        windowEnd++;
      }
    }

    return start == -1 ? "" : s.substring(start, start + minLength);
  }
}
