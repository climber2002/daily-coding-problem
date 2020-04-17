package algorithms.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GetTreeEdgesAntiClockwiseTest {

  private Node tree;

  @Before
  public void setupTree() {
    Node n13 = new Node(13, null, null);
    Node n14 = new Node(14, null, null);
    Node n11 = new Node(11, n13, n14);
    Node n8 = new Node(8, null, n11);
    Node n7 = new Node(7, null, null);
    Node n4 = new Node(4, n7, n8);
    Node n2 = new Node(2, null, n4);

    Node n15 = new Node(15, null, null);
    Node n16 = new Node(16, null, null);
    Node n12 = new Node(12, n15, n16);
    Node n9 = new Node(9, n12, null);
    Node n10 = new Node(10, null, null);
    Node n5 = new Node(5, n9, n10);
    Node n6 = new Node(6, null, null);
    Node n3 = new Node(3, n5, n6);
  
    Node n1 = new Node(1, n2, n3);
    this.tree = n1;
  }

  @Test
  public void testGetTreeEdgesAntiClockwise() {
    Integer[] result = GetTreeEdgesAntiClockwise.getTreeEdgesAntiClockwise(tree);
    assertArrayEquals(new Integer[] { 1, 2, 4, 7, 11, 13, 14, 15, 16, 12, 10, 6, 3 }, result);
  }
}
