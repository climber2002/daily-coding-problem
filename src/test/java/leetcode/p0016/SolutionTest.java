package leetcode.p0016;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(0, solution.threeSumClosest(new int[] {0, 2, 1, -3 }, 1));
  }
}
