package com.dailyCodingProblem;

/**
 * This problem was asked by LinkedIn.
 *
 * You are given a binary tree in a peculiar string representation. Each node is written in the form (lr),
 * where l corresponds to the left child and r corresponds to the right child.
 *
 * If either l or r is null, it will be represented as a zero. Otherwise, it will be represented by a new (lr) pair.
 *
 * Here are a few examples:
 *
 * A root node with no children: (00)
 * A root node with two children: ((00)(00))
 * An unbalanced tree with three consecutive left children: ((((00)0)0)0)
 * Given this representation, determine the depth of the tree.
 */
public class P357 {
  public static class Node {
    public Node left;
    public Node right;
  }

  public static int getDepth(String str) {
    if(str.equals("0")) {
      return 0;
    }

    String content = str.substring(1, str.length() - 1);
    String[] splitted = getSplitted(content);
    return 1 + Math.max(getDepth(splitted[0]), getDepth(splitted[1]));
  }

  public static int getDepth(Node node) {
    if(node == null) {
      return 0;
    }
    else {
      return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
  }

  public static Node parseTree(String str) {
    if(str.equals("0")) {
      return null;
    }

    String content = str.substring(1, str.length() - 1);
    String[] splitted = getSplitted(content);
    Node parent = new Node();
    parent.left = parseTree(splitted[0]);
    parent.right = parseTree(splitted[1]);
    return parent;
  }


  private static String[] getSplitted(String content) {
    if(content.startsWith("0")) {
      return new String[] { content.substring(0, 1), content.substring(1) };
    } else {
      int unmatchedBackets = 1;
      char[] chars = content.toCharArray();
      int i = 1;
      for(; i < content.length(); i++) {
        if(unmatchedBackets == 0) {
          break;
        }
        if(chars[i] == '(') {
          unmatchedBackets++;
        } else if(chars[i] == ')') {
          unmatchedBackets--;
        }
      }
      return new String[] { content.substring(0, i), content.substring(i) };
    }
  }
}
