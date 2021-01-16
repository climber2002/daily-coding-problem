package leetcode.p0210;

import java.util.*;

class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    try {
      Map<Integer, Set<Integer>> edges = new HashMap<>();

      for(int[] pre : prerequisites) {
        if(!edges.containsKey(pre[1])) {
          edges.put(pre[1], new HashSet<>(Arrays.asList(pre[0])));
        } else {
          edges.get(pre[1]).add(pre[0]);
        }
      }

      boolean[] visited = new boolean[numCourses];
      Stack<Integer> stack = new Stack<>();

      for(int i = 0; i < numCourses; i++) {
        if(!visited[i]) {
          dfs(i, edges, visited, stack, new HashSet<Integer>());
        }
      }

      int[] result = new int[numCourses];
      for(int i = 0; i < numCourses; i++) {
        result[i] = stack.pop();
      }
      return result;

    } catch(Exception ex) {
      return new int[0];
    }
  }


  private void dfs(int i, Map<Integer, Set<Integer>> edges, boolean[] visited, Stack<Integer> stack, Set<Integer> current) {
    visited[i] = true;
    if(edges.containsKey(i)) {
      current.add(i);
      Set<Integer> vertices = edges.get(i);
      for(int j : vertices) {
        if(!visited[j]) {
          dfs(j, edges, visited, stack, current);
        } else if(current.contains(j)) {
          throw new IllegalArgumentException();
        }
        current.remove(j);
      }
    }

    stack.push(i);
  }
}
