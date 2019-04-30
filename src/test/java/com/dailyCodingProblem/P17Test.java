package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class P17Test {

  @Test
  public void testParse_onlyRoot() {
    P17.Folder root = P17.parse("abc");
    assertEquals("abc", root.name);
    assertTrue(root.getChildren().isEmpty());
  }

  @Test
  public void testParse_oneLevel() {
    P17.Folder root = P17.parse("abc\n\tch");
    assertEquals("abc", root.name);
    assertEquals(1, root.getChildren().size());

    P17.Node child = root.getChildren().get(0);
    assertEquals("ch", child.name);
  }

  @Test
  public void testParse_multipleLevels() {
    P17.Folder root = P17.parse("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    assertEquals("dir", root.name);
  }

  @Test
  public void testParse_multipleLevels2() {
    P17.Folder root = P17.parse("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    assertEquals("dir", root.name);

    P17.Folder subdir1 = (P17.Folder)root.getChildren().get(0);
    assertEquals("subdir1", subdir1.name);

    P17.File file1 = (P17.File)subdir1.getChildren().get(0);
    assertEquals("file1.ext", file1.name);
  }

  public void testGetLongestFilePath() {
    int l = P17.getLongestFilePath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    assertEquals(32, l);
  }
}
