package leetcode.p0005;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  @Test
  public void test() {
    assertEquals("aacaa", new Solution().longestPalindrome("aacaabb"));
    assertEquals("bb", new Solution().longestPalindrome("cbbd"));
  }
}
