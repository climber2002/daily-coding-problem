package algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public BreadthFirstPaths(Graph G, int s) {
    this.s = s;
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
  }

  private void bfs(Graph G, int s) {
    marked[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    while(!queue.isEmpty()) {
      int v = queue.remove();
      for(int w : G.adj(v)) {
        if(!marked[w]) {
          marked[w] = true;
          edgeTo[w] = v;
          queue.add(w);
        }
      }
    }
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
}
