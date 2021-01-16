package leetcode.p0108;

class Solution {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) {
      return null;
    }
    return createTree(nums, 0, nums.length - 1);
  }

  private TreeNode createTree(int[] nums, int start, int end) {
    if(start > end) {
      return null;
    }

    int middle = start + (end + 1 - start) / 2;
    TreeNode root = new TreeNode(nums[middle]);
    root.left = createTree(nums, start, middle - 1);
    root.right = createTree(nums, middle + 1, end);
    return root;
  }
}
