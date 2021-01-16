package leetcode.p0953;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(false, solution.isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
  }
}
