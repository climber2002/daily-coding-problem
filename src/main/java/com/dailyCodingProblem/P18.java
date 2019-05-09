package com.dailyCodingProblem;

import java.util.*;

//This problem was asked by Google.
//
//    Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of
//    each subarray of length k.
//
//    For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
//
//    10 = max(10, 5, 2)
//    7 = max(5, 2, 7)
//    8 = max(2, 7, 8)
//    8 = max(7, 8, 7)
//    Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need
//    to store the results. You can simply print them out as you compute them.
public class P18 {

  public static int[] getMaxOfSubArray(int[] arr, int k) {
    Deque<Integer> deque = new ArrayDeque<Integer>();

    for(int i = 0; i < k; i++) {
      while(! deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }

    List<Integer> result = new ArrayList<Integer>();
    result.add(arr[deque.getFirst()]);


    for(int i = k; i < arr.length; i++) {
      while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
        deque.removeLast();
      }
      deque.addLast(i);

      while (!deque.isEmpty() && (i - deque.getFirst()) >= k ) {
        deque.removeFirst();
      }
      result.add(arr[deque.getFirst()]);
    }

    int[] resultArr = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      resultArr[i] = result.get(i);
    }
    return resultArr;
  }

}
