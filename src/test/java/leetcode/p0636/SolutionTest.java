package leetcode.p0636;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  @Test
  public void test() {
    List<String> stringList = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
    assertArrayEquals(new int[] {3, 4}, new Solution().exclusiveTime(2, stringList));
  }

  @Test
  public void test1() {
    List<String> stringList = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
    assertArrayEquals(new int[] {8}, new Solution().exclusiveTime(1, stringList));
  }
}
