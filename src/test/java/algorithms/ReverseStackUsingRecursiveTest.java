package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReverseStackUsingRecursiveTest {

  @Test
  public void testReverse() throws Exception {
    Stack<Integer> stack = new Stack<>();
    Arrays.asList(1, 2, 3, 4, 5).forEach(stack::push);
    Stack<Integer> reversed = ReverseStackUsingRecursive.reverse(stack);
    assertEquals((Integer) 1, reversed.peek());
  }
}
