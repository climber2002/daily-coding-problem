package algorithms.graph;

import algorithms.utils.In;

import java.util.HashSet;
import java.util.Set;

public class Digraph {
  private final int V;
  private int E;
  private Set<Integer>[] adj;

  public Digraph(int V) {
    this.V = V;
    this.E = 0;
    adj = (Set<Integer>[]) new Set[V];
    for(int v = 0; v < V; v++) {
      adj[v] = new HashSet<>();
    }
  }

  public Digraph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for(int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() { return this.V; }
  public int E() { return this.E; }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    E++;
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  public Digraph reverse() {
    Digraph R = new Digraph(V);
    for(int v = 0; v < V; v++) {
      for(int w : adj(v)) {
        R.addEdge(w, v);
      }
    }
    return R;
  }
}
