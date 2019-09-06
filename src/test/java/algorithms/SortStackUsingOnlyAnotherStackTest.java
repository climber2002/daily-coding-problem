package algorithms;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class SortStackUsingOnlyAnotherStackTest {

  @Test
  public void testSortStack() {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    Stack<Integer> sorted = SortStackUsingOnlyAnotherStack.sortStack(stack);

    assertArrayEquals(sorted.toArray(new Integer[0]), new Integer[] {5, 4, 3, 2, 1});
  }
}
