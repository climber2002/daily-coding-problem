package leetcode.p0046;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void test() {
    assertEquals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0)), solution.permute(new int[] {0, 1}));
  }
}
