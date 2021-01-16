package leetcode.p0072;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(0, solution.minDistance("", ""));
  }
}
