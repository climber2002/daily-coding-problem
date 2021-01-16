package leetcode.p0200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(1, solution.numIslands(new char[][] {
      new char[] {'1', '1', '1'},
      new char[] {'0', '1', '0'},
      new char[] {'1', '1', '1'} }));
  }
}
