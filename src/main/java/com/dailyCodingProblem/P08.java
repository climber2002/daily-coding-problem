package com.dailyCodingProblem;

//This problem was asked by Google.
//
//    A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
//
//    Given the root to a binary tree, count the number of unival subtrees.
//
// For example, the following tree has 5 unival subtrees:
//
//    0
//    / \
//    1   0
//      / \
//      1   0
//      / \
//      1   1

public class P08 {

  public static class Node {
    public final int val;
    public final Node left;
    public final Node right;

    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public Node(int val, Node left) {
      this(val, left, null);
    }

    public Node(int val) {
      this(val, null, null);
    }
  }

  public static int getNoOfUnivalSubtrees(Node node) {
    int total = 0;
    if(isUnivalSubtree(node)) {
      total = total +1;
    }
    if(node.left != null) {
      total += getNoOfUnivalSubtrees(node.left);
    }
    if(node.right != null) {
      total += getNoOfUnivalSubtrees((node.right));
    }
    return total;
  }

  private static boolean isUnivalSubtree(Node node) {
    if(node.left == null && node.right == null) {
      return true;
    }

    boolean isUnival = true;

    if(node.left != null) {
      isUnival = isUnival && (node.val == node.left.val) && isUnivalSubtree(node.left);
    }

    if(node.right != null) {
      isUnival = isUnival && (node.val == node.right.val) && isUnivalSubtree(node.right);
    }

    return isUnival;
  }
}
