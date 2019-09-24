package algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Get the common elements in two sorted list
 */
public class GetCommonElementsInSortedList {

  public static int[] getCommonElementsInSortedList(Node node1, Node node2) {
    List<Integer> result = new LinkedList<>();
    Node current1 = node1;
    Node current2 = node2;

    while(current1 != null && current2 != null) {
      int i1 = current1.value;
      int i2 = current2.value;
      if(i1 == i2) {
        result.add(i1);
        current1 = current1.next;
        current2 = current2.next;
      } else if(i1 > i2) {
        current2 = current2.next;
      } else {
        current1 = current1.next;
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
