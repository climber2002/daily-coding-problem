package leetcode.p0726;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * Solution: Only process 3 cases,
 * 1. The character is Upper case, then read the character and following lower case, and add 1 if next is not a number,
 * otherwise get the number as count and add count
 * 2. if character is (, push current map to stack
 * 3. if character is ), read next number as multiplier (1 if it's not a number), multiply current map and then merge
 * with the map popped from stack
 */
class Solution {
  public String countOfAtoms(String formula) {
    char[] chars = formula.toCharArray();
    int idx = 0;
    Map<String, Integer> map = new HashMap<>();
    Stack<Map<String, Integer>> stack = new Stack<>();
    while(idx < chars.length) {
      if(chars[idx] >= 'A' && chars[idx] <= 'Z') {
        StringBuilder builder = new StringBuilder();
        builder.append(chars[idx++]);
        while(idx < chars.length && chars[idx] >= 'a' && chars[idx] <= 'z') {
          builder.append(chars[idx]);
          idx++;
        }
        if(idx == chars.length || !isDigit(chars[idx])) {
          addCount(map, builder.toString(), 1);
        } else if(chars[idx] >= '0' && chars[idx] <= '9') {
          StringBuilder count = new StringBuilder();
          while(idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
            count.append(chars[idx++]);
          }
          addCount(map, builder.toString(), Integer.parseInt(count.toString()));
        }
      } else if(chars[idx] == '(') {
        stack.push(map);
        map = new HashMap<>();
        idx++;
      } else if(chars[idx] == ')') {
        idx++;
        int multiplier = 1;
        if(idx < chars.length && isDigit(chars[idx])) {
          StringBuilder count = new StringBuilder();
          while(idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
            count.append(chars[idx++]);
          }
          multiplier = Integer.parseInt(count.toString());
        }
        multiplyCount(map, multiplier);
        Map<String, Integer> orig = stack.pop();
        map = merge(orig, map);
      }
    }

    return map.entrySet().stream().sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
      .map(entry -> entry.getKey() + (entry.getValue() > 1 ? entry.getValue() : "")).collect(Collectors.joining());
  }

  private boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  private void addCount(Map<String, Integer> map, String element, int count) {
    Integer existing = map.getOrDefault(element, 0);
    map.put(element, existing + count);
  }

  private void multiplyCount(Map<String, Integer> map, int multiplier) {
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      map.put(entry.getKey(), entry.getValue() * multiplier);
    }
  }

  private Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
    for(Map.Entry<String, Integer> entry : map2.entrySet()) {
      if(map1.containsKey(entry.getKey())) {
        map1.put(entry.getKey(), map1.get(entry.getKey()) + entry.getValue());
      } else {
        map1.put(entry.getKey(), entry.getValue());
      }
    }
    return map1;
  }
}
