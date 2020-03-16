package algorithms.graph;

import algorithms.utils.In;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectedDFSTest {
  private Digraph G;
  private DirectedDFS dfs;

  @Before
  public void setUp() {
    In in = new In(getClass().getClassLoader().getResource("tinyG.txt"));
    G = new Digraph(in);
    dfs = new DirectedDFS(G, 0);
  }

  @Test
  public void testDfs() {
    assertEquals(true, dfs.marked(2));
    assertEquals(true, dfs.marked(4));
    assertEquals(true, dfs.marked(5));
  }
}
