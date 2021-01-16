package leetcode.p0239;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 },
      solution.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
  }
}
