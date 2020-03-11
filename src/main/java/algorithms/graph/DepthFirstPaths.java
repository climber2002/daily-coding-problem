package algorithms.graph;

import java.util.Stack;

public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s; // source vertex

  public DepthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    this.s = s;
    edgeTo = new int[G.V()];

    dfs(G, s);
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    Stack<Integer> stack = new Stack<>();
    int current = v;
    while(current != s) {
      stack.push(current);
      current = edgeTo[v];
    }
    stack.push(s);
    return stack;
  }

  private void dfs(Graph G, int v) {
    marked[v] = true;
    for(int w : G.adj(v)) {
      if(!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }
}
