package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This problem was asked by Microsoft.
//
//    Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
//    If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
//
//    For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
//    you should return ['the', 'quick', 'brown', 'fox'].
//
//    Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
//    return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
public class P22 {
  public static String[] getMadeUpWords(String sentence, List<String> words) {
    List<String> result = new ArrayList<>();
    return getWords(sentence, words, result).toArray(new String[0]);
  }

  private static List<String> getWords(String sentence, List<String> words, List<String> result) {
    if(sentence.isEmpty()) {
      return result;
    }

    for(String word : words) {
      if(sentence.startsWith(word)) {
        result.add(word);
        List<String> newResult = getWords(sentence.substring(word.length()), words, result);
        if(!newResult.isEmpty()) {
          return newResult;
        }
      }
    }
    return Collections.emptyList();
  }
}
