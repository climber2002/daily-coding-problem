package leetcode.p0953;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> positions = new HashMap<>();
    for(int i = 0; i < order.length(); i++) {
      positions.put(order.charAt(i), i);
    }

    for(int i = 0; i <= words.length - 2; i++) {
      char[] chars1 = words[i].toCharArray();
      char[] chars2 = words[i + 1].toCharArray();
      int i1 = 0;
      int i2 = 0;

      while(i1 < chars1.length && i2 < chars2.length) {
        if(chars1[i1] != chars2[i2]) {
          if(positions.get(chars1[i1]) > positions.get(chars2[i2])) {
            return false;
          } else {
            break;
          }
        }
        i1++;
        i2++;
      }

      if(i1 < chars1.length && i2 >= chars2.length) {
        return false;
      }
    }

    return true;
  }
}
