package com.dailyCodingProblem;

import java.util.*;

/**
 * This problem was asked by Spotify.
 *
 * You have access to ranked lists of songs for various users. Each song is represented as an integer,
 * and more preferred songs appear earlier in each list. For example, the list [4, 1, 7] indicates that a
 * user likes song 4 the best, followed by songs 1 and 7.
 *
 * Given a set of these ranked lists, interleave them to create a playlist that satisfies everyone's priorities.
 *
 * For example, suppose your input is {[1, 7, 3], [2, 1, 6, 7, 9], [3, 9, 5]}.
 * In this case a satisfactory playlist could be [2, 1, 6, 7, 3, 9, 5].
 */
public class P360 {
  public static Integer[] sortPlaylists(Set<Integer[]> playlists) {
    Graph graph = new Graph(playlists);
    return graph.topologySort();
  }

  public static class Graph {
    private Set<Integer> vertices;
    private Map<Integer, Set<Integer>> edges;

    public Graph(Set<Integer[]> playlists) {
      this.vertices = new HashSet<>();
      this.edges = new HashMap<>();

      for(Integer[] songs : playlists) {
        for(int i = 0; i < songs.length; i++) {
          int song = songs[i];
          vertices.add(song);
          Set<Integer> edgesForVertex = edges.getOrDefault(song, new HashSet<>());
          if(i + 1 < songs.length) {
            edgesForVertex.add(songs[i + 1]);
          }
          edges.putIfAbsent(song, edgesForVertex);
        }
      }
    }

    public Set<Integer> getVertices() {
      return this.vertices;
    }

    public Map<Integer, Set<Integer>> getEdges() {
      return this.edges;
    }

    public Set<Integer> getEdgesForVertex(int vertex) {
      return edges.getOrDefault(vertex, new HashSet<>());
    }

    public Integer[] topologySort() {
      Set<Integer> visited = new HashSet<>();
      Stack<Integer> stack = new Stack<>();
      for(Integer song : this.vertices) {
        if(!visited.contains(song)) {
          dfs(song, visited, stack);
        }
      }

      List<Integer> result = new ArrayList<>();
      while(!stack.isEmpty()) {
        result.add(stack.pop());
      }
      return result.toArray(new Integer[0]);
    }

    private void dfs(Integer vertex, Set<Integer> visited, Stack<Integer> stack) {
      visited.add(vertex);
      for(int next : this.getEdgesForVertex(vertex)) {
        if(!visited.contains(next)) {
          dfs(next, visited, stack);
        }
      }
      stack.push(vertex);
    }
  }
}
