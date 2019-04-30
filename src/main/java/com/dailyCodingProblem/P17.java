package com.dailyCodingProblem;

import java.util.*;

//This problem was asked by Google.
//
//    Suppose we represent our file system by a string in the following manner:
//
//    The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
//
//    dir
//      subdir1
//      subdir2
//        file.ext
//    The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
//
//    The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
//
//    dir
//      subdir1
//        file1.ext
//        subsubdir1
//      subdir2
//        subsubdir2
//          file2.ext
//    The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
//
//    We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
//
//    Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
//
//    Note:
//
//    The name of a file contains at least a period and an extension.
//
//    The name of a directory or sub-directory will not contain a period.
public class P17 {

  public static abstract class Node {
    protected final String name;

    public Node(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    public abstract int getLongestFilePath();
  }

  public static class Folder extends Node {
    private List<Node> children = new ArrayList<Node>();

    public Folder(String name) {
      super(name);
    }

    public void addChild(Node node) {
      this.children.add(node);
    }

    public List<Node> getChildren() {
      return children;
    }

    public int getLongestFilePath() {
      if(this.children.isEmpty()) {
        return 0;
      } else {
        Integer[] lengths = new Integer[this.children.size()];
        for(int i = 0; i < children.size(); i++) {
          lengths[i] = children.get(i).getLongestFilePath();
        }
        return name.length() + 1 + Collections.max(Arrays.asList(lengths));
      }
    }
  }

  public static class File extends Node {
    public File(String name) {
      super(name);
    }

    public int getLongestFilePath() {
      return name.length();
    }
  }

  public static int getLongestFilePath(String s) {
    Folder f = parse(s);
    return f.getLongestFilePath();
  }

  public static Folder parse(String s) {
    String[] paths = s.split("\n");
    Stack<Folder> stack = new Stack<Folder>();

    stack.push(new Folder(paths[0]));
    int currentLevel = 0;
    for(int i = 1; i < paths.length; i++) {
      PathItem pathItem = getPathItem(paths[i]);
      if(pathItem.level > currentLevel) {
        if(pathItem.name.contains(".")) {
          Folder parent = stack.peek();
          parent.addChild(new File(pathItem.name));
        } else {
          Folder parent = stack.peek();
          Folder folder = new Folder(pathItem.name);
          parent.addChild(folder);
          stack.push(folder);
          currentLevel++;
        }
      } else {
        Folder parent = null;
        for(int j = 0; j < currentLevel - pathItem.level; j++) {
          parent = stack.pop();
        }
        parent = stack.peek();
        if(pathItem.name.contains(".")) {
          parent.addChild(new File(pathItem.name));
        } else {
          Folder folder = new Folder(pathItem.name);
          parent.addChild(folder);
          stack.push(folder);
          currentLevel = pathItem.level;
        }
      }
    }

    Folder root = null;
    while(!stack.isEmpty()) {
      root = stack.pop();
    }

    return root;
  }

  private static PathItem getPathItem(String str) {
    int level = 0;
    String s = str;
    while(s.startsWith("\t")) {
      level++;
      s = s.substring("\t".length());
    }
    return new PathItem(level, s);
  }

  private static Node createNode(String name) {
    if(name.contains(".")) {
      return new File(name);
    } else {
      return new Folder(name);
    }
  }

  public static class PathItem {
    public final int level;
    public final String name;

    public PathItem(int level, String name) {
      this.level = level;
      this.name = name;
    }
  }


}
