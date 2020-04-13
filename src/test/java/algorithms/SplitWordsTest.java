package algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SplitWordsTest {

  @Test
  public void testSplitWords() {
    Set<List<String>> result = SplitWords.splitWords("BOTHEARTHANDSATURNSPIN".toLowerCase());
    assertEquals(2, result.size());
    List<List<String>> resultArray = new ArrayList<>(result);
    System.out.println(Arrays.toString(resultArray.get(0).toArray(new String[0])));
    System.out.println(Arrays.toString(resultArray.get(1).toArray(new String[0])));
  }
}
