package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LeftRightSmallerElementsOfArrayTest {

    @Test
    public void testGetNearLessNoRepeat() {
        int[][] result = LeftRightSmallerElementsOfArray.getNearLessNoRepeat(new int[] { 3, 4, 1, 5, 6, 2, 7 });
        assertEquals(7, result.length);
        assertArrayEquals(new int[] { -1, 2 }, result[0]);
        assertArrayEquals(new int[] { 0, 2 }, result[1]);
        assertArrayEquals(new int[] { -1, -1 }, result[2]);
        assertArrayEquals(new int[] { 2, 5 }, result[3]);
        assertArrayEquals(new int[] { 3, 5 }, result[4]);
        assertArrayEquals(new int[] { 2, -1 }, result[5]);
        assertArrayEquals(new int[] { 5, -1 }, result[6]);
    }
}
