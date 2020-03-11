package algorithms.graph;

public class DepthFirstSearch extends Search {
  private boolean[] marked;
  private int count;

  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    dfs(G, s);
  }

  public boolean marked(int w) {
    return marked[w];
  }

  public int count() {
    return count;
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    this.count++;
    for(int w : G.adj(v)) {
      if(!marked[w]) {
        dfs(G, w);
      }
    }
  }
}
