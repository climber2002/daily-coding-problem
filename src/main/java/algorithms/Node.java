package algorithms;

import java.util.Stack;

/**
 * The common class to represent an integer list
 */
public class Node {

  public static Node createNodeFrom(int ... args) {
    Stack<Integer> stack = new Stack<>();
    for(int i: args) {
      stack.push(i);
    }

    Node current = null;
    while(!stack.isEmpty()) {
      current = new Node(stack.pop(), current);
    }
    return current;
  }

  public final int value;
  public final Node next;

  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }

  public boolean hasNext() {
    return next != null;
  }
}
