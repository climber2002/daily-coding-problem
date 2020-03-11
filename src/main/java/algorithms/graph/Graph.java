package algorithms.graph;

import algorithms.utils.In;

import java.util.HashSet;
import java.util.Set;

public class Graph {
  private final int V; // number of vertices
  private int E; // number of edges
  private Set<Integer>[] adj; // adjacency lists

  public Graph(int V) {
    this.V = V;
    this.E = 0;
    this.adj = (Set<Integer>[]) new Set[V];
    for(int v = 0; v < V; v++) {
      adj[v] = new HashSet<Integer>();
    }
  }

  public Graph(In in) {
    this(in.readInt());
    int E = in.readInt();
    for(int i = 0; i < E; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  public int V() { return V; }
  public int E() { return E; }

  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
  }

  public Iterable<Integer> adj(int v) {
    return adj[v];
  }
}
