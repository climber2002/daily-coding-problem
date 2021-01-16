package algorithms.array;

//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//  If target is not found in the array, return [-1, -1].
public class FindFirstAndLastPositionOfElementInSortedArray {
//  public int binarySearch(int[] nums, int target) {
//
//  }

  public static int findUpperIndex(int[] nums, int lo, int hi, int target) {
    if(lo > hi) {
      return hi;
    }

    int middle = lo + (hi - lo) / 2;
    System.out.println("lo: " + lo + ", hi: " + hi + ", middle: " + middle );
    if(nums[middle] <= target) {
      return findUpperIndex(nums, middle + 1, hi, target);
    } else {
      return findUpperIndex(nums, lo, middle - 1, target);
    }
  }
}
