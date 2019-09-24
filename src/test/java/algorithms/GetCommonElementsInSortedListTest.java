package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GetCommonElementsInSortedListTest {

  @Test
  public void testGetCommonElementsInSortedList() {
    Node node1 = Node.createNodeFrom(1, 3, 4, 6, 7, 9, 12, 15);
    Node node2 = Node.createNodeFrom(2, 3, 5, 8, 9, 10, 13);

    int[] result = GetCommonElementsInSortedList.getCommonElementsInSortedList(node1, node2);
    assertArrayEquals(new int[] { 3, 9 }, result);
  }
}
