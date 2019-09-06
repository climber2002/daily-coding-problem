package algorithms;

import java.util.Stack;

/**
 * Sort a stack of integers using only another stack
 */
public class SortStackUsingOnlyAnotherStack {

  public static Stack<Integer> sortStack(Stack<Integer> stack) {
    if(stack.isEmpty()) {
      return stack;
    }
    Stack<Integer> sortedStack = new Stack<>();
    while(!stack.isEmpty()) {
      Integer i = stack.pop();
      addToStackSorted(sortedStack, i);
    }

    while(!sortedStack.isEmpty()) {
      Integer i = sortedStack.pop();
      stack.push(i);
    }
    return stack;
  }

  private static void addToStackSorted(Stack<Integer> sortedStack, Integer i) {
    if(sortedStack.isEmpty()) {
      sortedStack.push(i);
      return;
    }

    Integer top = sortedStack.peek();
    if(top < i) {
      sortedStack.push(i);
    } else {
      top = sortedStack.pop();
      addToStackSorted(sortedStack, i);
      sortedStack.push(top);
    }
  }
}
