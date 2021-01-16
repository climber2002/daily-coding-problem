package leetcode.p0066;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  @Test
  public void test() {
    assertArrayEquals(new int[] {9, 0, 0, 0}, new Solution().plusOne(new int[] {8, 9, 9, 9}));
  }
}
