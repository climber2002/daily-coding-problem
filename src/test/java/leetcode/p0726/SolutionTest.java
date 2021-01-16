package leetcode.p0726;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution = new Solution();

  @Test
  public void testSimple() {
    assertEquals("H2O", solution.countOfAtoms("H2O"));
    assertEquals("Be32", solution.countOfAtoms("Be32"));
  }

  @Test
  public void testBrackets() {
    assertEquals("H2MgO2", solution.countOfAtoms("Mg(OH)2"));
    assertEquals("K4N2O14S4", solution.countOfAtoms("K4(ON(SO3)2)2"));
  }
}
