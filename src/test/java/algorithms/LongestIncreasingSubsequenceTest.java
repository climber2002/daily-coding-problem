package algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
  @Test
  public void testGetLongestIncreasingSubsequence() {
    assertEquals(4, LongestIncreasingSubsequence.getLongestIncreasingSubsequence(new int[] {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}));
  }

  @Test
  public void testGetLongestIncreasingSubsequenceResult() {
    int[] longest =  LongestIncreasingSubsequence.
      getLongestIncreasingSubsequenceResult(new int[] {3, 1, 1, 5, 9, 10, 2, 6, 1, 2, 3, 4, 5, 3, 5, 6, 7, 8, 9, 10, 11});
    System.out.println(Arrays.toString(longest));
  }
}
