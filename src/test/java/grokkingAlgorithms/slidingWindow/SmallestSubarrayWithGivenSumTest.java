package grokkingAlgorithms.slidingWindow;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SmallestSubarrayWithGivenSumTest {
    @Test
    public void test() {
        assertEquals(2, SmallestSubarrayWithGivenSum.getAnswer(new int[] { 2, 1, 5, 2, 3, 2 }, 7));
        assertEquals(1, SmallestSubarrayWithGivenSum.getAnswer(new int[] { 2, 1, 5, 2, 8 }, 7));
        assertEquals(3, SmallestSubarrayWithGivenSum.getAnswer(new int[] { 3, 4, 1, 1, 6 }, 8));
    }
}
