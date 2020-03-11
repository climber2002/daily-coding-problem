package algorithms.graph;

import algorithms.utils.In;
import org.junit.Test;

public class SearchTest {

  @Test
  public void testSearch_dfs_notConnected() {
    In in = new In(getClass().getClassLoader().getResource("tinyG.txt"));
    Graph G = new Graph(in);
    int s = 0;
    Search search = new DepthFirstSearch(G, s);

    for(int v = 0; v < G.V(); v++) {
      if(search.marked(v)) {
        System.out.println(v + " ");
      }
    }

    System.out.println();

    if(search.count() != G.V())
      System.out.println("NOT ");

    System.out.println("connected");
  }
}
