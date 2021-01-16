package leetcode.p0005;

import java.util.Arrays;

class Solution {
  public String longestPalindrome(String s) {
    if(s.isEmpty()) {
      return "";
    }

    char[] chars = s.toCharArray();

    char[] longestPalidrome = longestPalindrom(chars);
    return new String(longestPalidrome);
  }

  private char[] longestPalindrom(char[] chars) {
    int n = chars.length;
    boolean[][] dp = new boolean[n][n];
    int maxLength = 1;
    int start = 0;
    for(int i = 0; i < n; i++) {
      dp[i][i] = true;
      if(i + 1 < n && (chars[i] == chars[i + 1])) {
        dp[i][i + 1] = true;
        if(i + 1 - i + 1 > maxLength) {
          maxLength = 2;
          start = i;
        }
      }
    }

    int k = 2;

    while(k < n) {
      for(int i = 0; i < n; i++) {
        if(i + k < n && dp[i + 1][i + k - 1] && chars[i] == chars[i + k]) {
          dp[i][i + k] = true;
          if(k + 1 > maxLength) {
            maxLength = k + 1;
            start = i;
          }
        }
      }
      k++;
    }

    return Arrays.copyOfRange(chars, start, start + maxLength);
  }


}