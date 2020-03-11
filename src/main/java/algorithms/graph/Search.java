package algorithms.graph;

public abstract class Search {
//  public abstract Search(Graph G, int s);  // source vertex s

  public abstract boolean marked(int v);

  /**
   * How many vertices are connected to S
   * @return
   */
  public abstract int count();
}
