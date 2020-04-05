package com.dailyCodingProblem;

import java.util.*;

import static java.util.Map.entry;

public class P362Answer {
  public static final Map<Integer, Integer> flips = Map.ofEntries(
    entry(0, 0),
    entry(1, 1),
    entry(6, 9),
    entry(8, 8),
    entry(9, 6)
  );

  public static final Set<Integer> keys = flips.keySet();

  public static Set<Integer> getStrobogrammaticNumbers(int n) {
    Set<Integer> result = new HashSet<>();
    backtrack(n, new ArrayList<>(), result);
    return result;
  }

  public static void backtrack(int n, List<Integer> current, Set<Integer> result) {
    if(current.size() == (n + 1) / 2) {
      if(current.get(0) != 0 && ((n % 2 == 0) ||
        (n % 2 != 0 && (current.get(current.size() - 1) != 6 && current.get(current.size() - 1) != 9)))) {
        result.add(convertToInt(current, n % 2 == 0));
      }
    } else {
      for(int digit : keys) {
        current.add(digit);
        backtrack(n, current, result);
        current.remove(current.size() - 1);
      }
    }
  }

  public static Integer convertToInt(List<Integer> digits, boolean isEven) {
    List<Integer> prefix = isEven ? digits.subList(0, digits.size()) : digits.subList(0, digits.size() - 1);
    List<Integer> resultList = new ArrayList<>(prefix);
    for(int i = digits.size() - 1; i >= 0; i--) {
      resultList.add(flips.get(digits.get(i)));
    }
    int result = 0;
    for(int i = 0; i < resultList.size(); i++) {
      result = 10 * result + resultList.get(i);
    }
    return result;
  }
}
