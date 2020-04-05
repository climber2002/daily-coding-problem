package com.dailyCodingProblem;

import java.util.*;
import java.util.stream.Collectors;

public class P361 {
  private static boolean corresponds(String guess, String code, int score) {
    int correct = 0;
    char[] guessChars = guess.toCharArray();
    char[] codeChars = code.toCharArray();
    for(int i = 0; i < guessChars.length; i++) {
      if(guessChars[i] == codeChars[i]) {
        correct++;
      }
    }
    return correct == score;
  }

  public static List<List<Integer>> combinations(Integer[] ints, int size) {
    if(size <= 0 || ints.length < size) {
      return Collections.emptyList();
    }

    if(size == 1) {
      List<List<Integer>> result = new ArrayList<>();
      for(int i = 0; i < ints.length; i ++) {
        result.add(new ArrayList(Arrays.asList(ints[i])));
      }
      return result;
    }

    Integer i = ints[0];
    List<List<Integer>> result = combinations(Arrays.copyOfRange(ints, 1, ints.length), size - 1).stream()
      .map(list -> { list.add(0, i); return list; }).collect(Collectors.toList());
    result.addAll(combinations(Arrays.copyOfRange(ints, 1, ints.length), size));
    return result;
  }
}
