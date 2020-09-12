package algorithms.graph;

public class TwoColor {
  enum Color {
    WHITE,
    BLACK
  }

  private boolean[] marked;
  private Color[] colors;

  private boolean twoColorable;

  public TwoColor(Graph G) {
    this.marked = new boolean[G.V()];
    this.colors = new Color[G.V()];
    this.twoColorable = true;

    for(int s = 0; s < G.V(); s++) {
      if(!marked[s]) {
        dfs(G, s, Color.WHITE);
      }
    }
  }

  public boolean isTwoColorable() {
    return this.twoColorable;
  }

  private void dfs(Graph G, int v, Color color) {
    marked[v] = true;
    colors[v] = color;

    for(int w : G.adj(v)) {
      if(!marked[w]) {
        dfs(G, v, otherColor(color));
      } else if(colors[w] == color) {
        this.twoColorable = false;
      }
    }
  }

  private Color otherColor(Color color) {
    if(color == Color.WHITE) {
      return Color.BLACK;
    } else {
      return Color.WHITE;
    }
  }
}
