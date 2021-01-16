package leetcode.p0239;

import java.util.*;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>(); // saves index
    int left = 0;
    int right = 0;

    while(right < nums.length) {
      while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
        deque.removeLast();
      }
      deque.offerLast(right++);

      if(right - left == k) {
        result[left] = nums[deque.peekFirst()];

        left++;
        if(deque.peekFirst() < left) {
          deque.removeFirst();
        }
      }
    }

    return result;
  }
}
