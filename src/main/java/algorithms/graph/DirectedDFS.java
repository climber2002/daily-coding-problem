package algorithms.graph;

public class DirectedDFS {
  private boolean[] marked;

  public DirectedDFS(Digraph G, int s) {
    this.marked = new boolean[G.V()];

    dfs(G, s);
  }

  public DirectedDFS(Digraph G, Iterable<Integer> sources) {
    this.marked = new boolean[G.V()];
    for(int s : sources) {
      dfs(G, s);
    }
  }

  public boolean marked(int v) {
    return marked[v];
  }

  private void dfs(Digraph G, int v) {
    marked[v] = true;
    for(int w : G.adj(v)) {
      if(!marked[w]) {
        dfs(G, w);
      }
    }
  }
}
