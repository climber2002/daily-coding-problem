package grokkingAlgorithms.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public static int getResult(String s, int K) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> counts = new HashMap<>();
        while(right < chars.length) {
          counts.put(chars[right], counts.getOrDefault(chars[right], 0) + 1);

          while (counts.size() > K) {
              counts.put(chars[left], counts.get(chars[left]) - 1);
              if(counts.get(chars[left]) == 0) {
                  counts.remove(chars[left]);
              }
              left++;
          }
          if(counts.size() == K) {
              result = Math.max(result, right - left + 1);
          }

          right++;
        }

        return result;
    }
}
