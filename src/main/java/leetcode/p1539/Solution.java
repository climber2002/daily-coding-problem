package leetcode.p1539;

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int findKthPositive(int[] arr, int k) {
    int i = 0;
    while(i < arr.length) {
      if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
        swap(arr, i, arr[i] - 1);
      } else {
        i++;
      }
    }

    int missingIdx = 0;
    Set<Integer> extraNumbers = new HashSet<>();
    for(i = 0; i < arr.length; i++) {
      if(arr[i] - 1 != i) {
        missingIdx++;
        if(missingIdx == k) {
          return i + 1;
        }
        extraNumbers.add(arr[i]);
      }
    }

    int remaining = arr.length + 1;
    missingIdx++;

    while(missingIdx < k) {
      if(extraNumbers.contains(remaining)) {
        while(extraNumbers.contains(remaining)) {
          remaining++;
        }
      } else {
        remaining++;
        missingIdx++;
      }
    }

    while(extraNumbers.contains(remaining)) {
      remaining++;
    }
    return remaining;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
