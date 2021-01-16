package leetcode.p0076;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    assertEquals("A", solution.minWindow("ADOBECODEBANC", "A"));
  }
}
