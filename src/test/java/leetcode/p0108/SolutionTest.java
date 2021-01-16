package leetcode.p0108;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void test() {
    Solution.TreeNode root = new Solution().sortedArrayToBST(new int[] {-10, -3, 0, 5, 9});
    assertEquals(0, root.val);
  }
}
