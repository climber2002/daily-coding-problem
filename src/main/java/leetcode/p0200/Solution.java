package leetcode.p0200;

class Solution {
  private boolean[][] visited;
  private int result = 0;

  public int numIslands(char[][] grid) {
    this.visited = new boolean[grid.length][grid[0].length];
    for(int r = 0; r < grid.length; r++) {
      for(int c = 0; c < grid[0].length; c++) {
        dfs(grid, r, c, true);
      }
    }
    return result;
  }


  private void dfs(char[][] grid, int row, int col, boolean beginning) {
    if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || visited[row][col]) {
      return;
    }

    if(grid[row][col] == '0') {
      visited[row][col] = true;
      return;
    } else {
      if(beginning) {
        result++;
      }

      visited[row][col] = true;
      dfs(grid, row + 1, col, false);
      dfs(grid, row, col + 1, false);
      dfs(grid, row, col - 1, false);
    }
  }
}
