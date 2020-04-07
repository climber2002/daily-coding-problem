package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SubsetSumTest {

  @Test
  public void testSubset() {
    Set<Integer> set = new TreeSet<>(Arrays.asList(1, 2));
    Integer sum = 3;
    Set<Set<Integer>> subsets = SubsetSum.getSubsets(set, sum);
    assertEquals(1, subsets.size());
    Integer[] result = subsets.iterator().next().toArray(new Integer[0]);
    Arrays.sort(result);
    assertArrayEquals(new Integer[] { 1, 2 }, result);
  }

  @Test
  public void testSubset_2() {
    Set<Integer> set = new HashSet<>(Arrays.asList(8, 7, 6));
    Integer sum = 15;
    Set<Set<Integer>> subsets = SubsetSum.getSubsets(set, sum);
    assertEquals(1, subsets.size());
  }
}
