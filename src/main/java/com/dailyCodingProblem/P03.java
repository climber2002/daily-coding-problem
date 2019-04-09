package com.dailyCodingProblem;

import java.util.Objects;
import java.util.Stack;

//This problem was asked by Google.
//
//    Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
//    and deserialize(s), which deserializes the string back into the tree.
//
//    For example, given the following Node class
//
//class Node:
//    def __init__(self, val, left=None, right=None):
//    self.val = val
//    self.left = left
//    self.right = right
//    The following test should pass:
//
//    node = Node('root', Node('left', Node('left.left')), Node('right'))
//    assert deserialize(serialize(node)).left.left.val == 'left.left'
public class P03 {

  static class Node {
    private String value;
    private Node left;
    private Node right;

    public Node(String value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public Node(String value, Node left) {
      this(value, left, null);
    }

    public Node(String value) {
      this(value, null, null);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return Objects.equals(value, node.value) &&
          Objects.equals(left, node.left) &&
          Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, left, right);
    }

    public String getValue() {
      return value;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }
  }

  public static String serialize(Node node) {
    StringBuilder builder = new StringBuilder("Node(");
    builder.append("'" + node.value + "'");
    builder.append(",");
    if(node.left != null) {
      builder.append(serialize(node.left));
    } else {
      builder.append("|");
    }
    builder.append(",");
    if(node.right != null) {
      builder.append(serialize(node.right));
    }else {
      builder.append("|");
    }
    builder.append(")");
    return builder.toString();
  }

  public static Node deserialize(String serialized) {
    Stack stack = new Stack();
    deserialize(serialized, stack);
    return (Node)stack.pop();
  }

  private static void deserialize(String str, Stack stack) {
    if(str.startsWith("Node(")) {
      String val = str.substring("Node(".length(), str.indexOf(','));
      stack.push(val.substring(1, val.length() - 1));
      deserialize(str.substring(str.indexOf(',') + 1), stack);
    } else if(str.startsWith(",")) {
      deserialize(str.substring(1), stack);
    } else if(str.startsWith("|")) {
      stack.push(null);
      deserialize(str.substring(1), stack);
    } else if(str.startsWith(")")) {
      Node right = (Node)stack.pop();
      Node left = (Node)stack.pop();
      String val = (String)stack.pop();
      stack.push(new Node(val, left, right));
      deserialize(str.substring(1), stack);
    }
  }

}
