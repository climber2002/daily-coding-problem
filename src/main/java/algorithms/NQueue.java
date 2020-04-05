package algorithms;

import java.util.Arrays;

public class NQueue {
  public static void placeQueues(int[] queues, int row) {
    if(queues.length == row) {
      System.out.println(Arrays.toString(queues));
      return;
    }

    for(int j = 0; j < queues.length; j++) {
      boolean legal = true;
      for(int i = 0; i < row; i++) {
        if(queues[i] == j || queues[i] == j + row - i || queues[i] == j - row + i) {
          legal = false;
        }
      }
      if(legal) {
        queues[row] = j;
        placeQueues(queues, row + 1);
      }
    }
  }
}
