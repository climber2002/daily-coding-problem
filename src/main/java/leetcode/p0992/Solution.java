package leetcode.p0992;

import java.util.*;

class Solution {
  public int subarraysWithKDistinct(int[] A, int K) {
    // key is integer, value is count of that integer in subarray
    Map<Integer, Integer> counts = new HashMap<>();

    int left = 0;
    int right = 0;
    int result = 0;
    while(right < A.length) {
      while (right < A.length && counts.size() <= K) {
        if(counts.containsKey(A[right]) || counts.size() < K) {
          add(counts, A[right++]);
          if(counts.size() == K) {
            result++;
            System.out.println(Arrays.toString(Arrays.copyOfRange(A, left, right)));
          }
        } else {
          break;
        }
      }

      while(counts.size() >= K) {
        int iLeft = A[left++];
        remove(counts, iLeft);
        if(counts.size() == K) {
          result++;
          System.out.println(Arrays.toString(Arrays.copyOfRange(A, left, right)));
        }
      }
    }

    return result;
  }

  private void add(Map<Integer, Integer> counts, int i) {
    counts.put(i, counts.getOrDefault(i, 0) + 1);
  }

  private void remove(Map<Integer, Integer> counts, int i) {
    int count = counts.get(i);
    if(count == 1) {
      counts.remove(i);
    } else {
      counts.put(i, count - 1);
    }
  }
}
