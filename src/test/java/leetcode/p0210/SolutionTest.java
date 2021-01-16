package leetcode.p0210;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

  private Solution solution = new Solution();

  @Test
  public void test() {
    assertArrayEquals(new int[] { 0, 2, 1, 3}, solution.findOrder(4, new int[][] {
      new int[] {1, 0}, new int[] {2, 0}, new int[] { 3, 1 }, new int[] { 3, 2}
    }));
  }
}
