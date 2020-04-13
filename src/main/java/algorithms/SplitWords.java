package algorithms;

import java.util.*;

public class SplitWords {

  private static Set<String> words = new HashSet<>(Arrays.asList("both", "earth", "and", "saturn", "spin",
    "bot", "heart", "hands", "at", "urns", "pin"));

  public static Set<List<String>> splitWords(String sentence) {
    Set<List<String>> result = new HashSet<>();
    backtrack(sentence, 0, new ArrayList<>(), result);
    return result;
  }

  private static void backtrack(String sentence, int currentIndex, List<String> current, Set<List<String>> result) {
    if(currentIndex == sentence.length()) {
      result.add(new ArrayList<>(current));
      return;
    }

    for(int endIndex = currentIndex; endIndex <= sentence.length(); endIndex++) {
      if(isWord(sentence, currentIndex, endIndex)) {
        current.add(sentence.substring(currentIndex, endIndex));
        backtrack(sentence, endIndex, current, result);
        current.remove(current.size() - 1);
      }
    }
  }

  private static boolean isWord(String sentence, int start, int end) {
    return words.contains(sentence.substring(start, end));
  }
}
