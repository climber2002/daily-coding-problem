package algorithms.graph;

/**
 * Check connected components
 */
public class CC {
  private int[] ids;
  private boolean[] marked;
  private int count;

  public CC(Graph G) {
    this.marked = new boolean[G.V()];
    this.ids = new int[G.V()];
    this.count = 0;

    for(int i = 0; i < G.V(); i++) {
      if(!marked[i]) {
        dfs(G, i);
        this.count++;
      }
    }
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    ids[v] = count;

    for(int w : G.adj(v)) {
      if(!marked[w]) {
        dfs(G, w);
      }
    }
  }

  public int count() {
    return count;
  }

  public int id(int v) {
    return ids[v];
  }

  public boolean connected(int v, int w) {
    return id(v) == id(w);
  }
}
