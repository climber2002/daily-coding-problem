package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
  public static int getLongestIncreasingSubsequence(int[] arr) {
    return backtrackLongestIncreasingSubsequence(arr, 0, 1);
  }

  private static int backtrackLongestIncreasingSubsequence(int[] arr, int i, int j) {
    if(j >= arr.length) {
      return 0;
    } else if(arr[i] > arr[j]) {
      return backtrackLongestIncreasingSubsequence(arr, i, j + 1);
    } else {
      int skip = backtrackLongestIncreasingSubsequence(arr, i, j + 1);
      int take = backtrackLongestIncreasingSubsequence(arr, j, j + 1) + 1;
      return Math.max(skip, take);
    }
  }

  public static int[] getLongestIncreasingSubsequenceResult(int[] arr) {
    int[] temp = new int[arr.length + 1];
    temp[0] = Integer.MIN_VALUE;
    for(int i = 0; i < arr.length; i++) {
      temp[i + 1] = arr[i];
    }
    return backtrackLongestIncreasingSubsequenceResult(temp, 0, 1, new ArrayList<>());
  }

  private static int[] backtrackLongestIncreasingSubsequenceResult(int[] arr, int i, int j, List<Integer> result) {
    if(j >= arr.length) {
      return result.stream().mapToInt(Integer::intValue).toArray();
    } else if(arr[i] >= arr[j]) {
      return backtrackLongestIncreasingSubsequenceResult(arr, i, j + 1, result);
    } else {
      int[] skip = backtrackLongestIncreasingSubsequenceResult(arr, i, j + 1, result);
      result.add(arr[j]);
      int[] take = backtrackLongestIncreasingSubsequenceResult(arr, j, j + 1, result);
      result.remove(result.size() - 1);

      if(skip.length > take.length) {
        return skip;
      } else {
        return take;
      }
    }
  }
}
