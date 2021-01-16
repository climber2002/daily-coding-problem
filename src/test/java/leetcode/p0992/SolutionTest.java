package leetcode.p0992;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(7, solution.subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
  }
}
