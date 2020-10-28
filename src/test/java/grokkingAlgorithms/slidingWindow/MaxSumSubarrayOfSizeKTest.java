package grokkingAlgorithms.slidingWindow;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxSumSubarrayOfSizeKTest {
    @Test
    public void test() {
        assertEquals(9, MaxSumSubarrayOfSizeK.getMaxOfSubarray(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
        assertEquals(7, MaxSumSubarrayOfSizeK.getMaxOfSubarray(new int[] { 2, 3, 4, 1, 5 }, 2));
    }
}
