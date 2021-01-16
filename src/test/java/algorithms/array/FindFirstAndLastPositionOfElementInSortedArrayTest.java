package algorithms.array;

import org.junit.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

  @Test
  public void testFindUpperIndex() {
    int[] nums = new int[] { 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 6, 6 };

    int index = FindFirstAndLastPositionOfElementInSortedArray.findUpperIndex(nums, 0, nums.length - 1, 3);
    System.out.println(index);
  }

  @Test
  public void testFindUpperIndex2() {
    int[] nums = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };

    int index = FindFirstAndLastPositionOfElementInSortedArray.findUpperIndex(nums, 0, nums.length - 1, 3);
    System.out.println(index);
  }
}
