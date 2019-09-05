package algorithms;

import java.util.Stack;

/**
 * Reverse a stack using only recursive
 */
public class ReverseStackUsingRecursive {

  public static <T> Stack<T> reverse(Stack<T> stack) {
    return go(stack, new Stack<T>());
  }

  private static <T> Stack<T> go(Stack<T> origin, Stack<T> result) {
    if(origin.isEmpty()) {
      return result;
    } else {
      T item = origin.pop();
      result.push(item);
      return go(origin, result);
    }
  }
}
