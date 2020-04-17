package algorithms.tree;

public class Node {
  private Node left;
  private Node right;
  private int value;

  public Node(int value, Node left, Node right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public boolean isLeaf() {
    return this.left == null && this.right == null;
  }

  public boolean hasLeft() {
    return this.left != null;
  }

  public boolean hasRight() {
    return this.right != null;
  }

  public Node getLeft() {
    return this.left;
  }

  public Node getRight() {
    return this.right;
  }

  public int getValue() {
    return this.value;
  }
}
