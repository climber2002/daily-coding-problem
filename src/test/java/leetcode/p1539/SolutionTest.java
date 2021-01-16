package leetcode.p1539;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(9, solution.findKthPositive(new int[] {2,3,4,7,11}, 5));
  }

  @Test
  public void test2() {
    assertEquals(6, solution.findKthPositive(new int[] {1, 2, 3, 4}, 2));
  }
}
