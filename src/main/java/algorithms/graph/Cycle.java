package algorithms.graph;

public class Cycle {
  private boolean[] marked;
  private boolean hasCycle;

  public Cycle(Graph G) {
    marked = new boolean[G.V()];
    for(int s = 0; s < G.V(); s++) {
      if(!marked[s]) {
        dfs(G, s, s);
      }
    }
  }

  public boolean hasCycle() {
    return hasCycle;
  }

  private void dfs(Graph G, int v, int s) {
    marked[v] = true;
    for(int w : G.adj(v)) {
      if(!marked[w]) {
        dfs(G, w, v);
      } else if(w != s) {
        hasCycle = true;
      }
    }
  }
}