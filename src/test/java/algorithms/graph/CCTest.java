package algorithms.graph;

import algorithms.utils.In;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CCTest {
  private In in = new In(getClass().getClassLoader().getResource("tinyG.txt"));
  private Graph G = new Graph(in);
  private CC cc = new CC(G);

  @Test
  public void testCount() {
    assertEquals(3, cc.count());
  }

  @Test
  public void testId() {
    assertEquals(cc.id(0), cc.id(2));
  }
}
