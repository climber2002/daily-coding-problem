package algorithms.tree;

import java.util.*;

public class GetTreeEdgesAntiClockwise {

  public static Integer[] getTreeEdgesAntiClockwise(Node tree) {
    List<Integer> result = new ArrayList<>();
    if(tree != null) {
      result.add(tree.getValue());
    }

    if(tree.hasLeft()) {
      processLeft(tree.getLeft(), result);
    }
    if(tree.hasRight()) {
      processRight(tree.getRight(), result);
    }

    return result.toArray(new Integer[0]);
  }

  private static void processLeft(Node node, List<Integer> result) {
    result.add(node.getValue());
    Queue<Node> queue = new ArrayDeque<>();
    if(!node.isLeaf()) {
      queue.add(node);
    }

    while(!queue.isEmpty()) {
      Node current = queue.remove();
      if(current.hasLeft()) {
        Node left = current.getLeft();
        if(left.isLeaf()) {
          result.add(left.getValue());
          if(current.hasRight()) {
            if(current.getRight().isLeaf()) {
              result.add(current.getRight().getValue());
            } else {
              queue.add(current.getRight());
            }
          }
        } else {
          queue.add(current.getLeft());
        }
      } else if(current.hasRight()) {
        Node right = current.getRight();
        if(right.isLeaf()) {
          result.add(right.getValue());
        } else {
          result.add(right.getValue());
          queue.add(right);
        }
      }
    }
  }

  private static void processRight(Node node, List<Integer> result) {
    List<Integer> resultReversed = new ArrayList<>();
    resultReversed.add(node.getValue());

    Queue<Node> queue = new ArrayDeque<>();
    if(!node.isLeaf()) {
      queue.add(node);
    }

    while(!queue.isEmpty()) {
      Node current = queue.remove();
      if(current.hasRight()) {
        Node right = current.getRight();
        if(right.isLeaf()) {
          resultReversed.add(right.getValue());
          if(current.hasLeft()) {
            if(current.getLeft().isLeaf()) {
              resultReversed.add(current.getLeft().getValue());
            } else {
              queue.add(current.getLeft());
            }
          }
        } else {
          queue.add(current.getRight());
        }
      } else if(current.hasLeft()) {
        Node left = current.getLeft();
        if(left.isLeaf()) {
          resultReversed.add(left.getValue());
        } else {
          resultReversed.add(left.getValue());
          queue.add(left);
        }
      }
    }
    Collections.reverse(resultReversed);
    result.addAll(resultReversed);
  }
}
