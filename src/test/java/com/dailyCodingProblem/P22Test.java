package com.dailyCodingProblem;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
public class P22Test {
  @Test
  public void testGetMadeUpWords() {
    List<String> words = Arrays.asList("quick", "brown", "the", "fox");
    String[] result = P22.getMadeUpWords("thequickbrownfox", words);
    assertArrayEquals(new String[] { "the", "quick", "brown", "fox"}, result);
  }

  @Test
  public void testGetMadeUpWords2() {
    List<String> words = Arrays.asList("bed", "bath", "bedbath", "and", "beyond");
    String[] result = P22.getMadeUpWords("bedbathandbeyond", words);
    assertArrayEquals(new String[] { "bed", "bath", "and", "beyond"}, result);
  }
}
