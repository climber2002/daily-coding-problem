package com.dailyCodingProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P20 {

  public static Integer getIntersecting(List<Integer> listA, List<Integer> listB) {
    Set<Integer> setA = new HashSet<Integer>();
    for(int i = 0; i < listA.size(); i++) {
      setA.add(listA.get(i));
    }

    for(int i = 0; i < listB.size(); i++) {
      if(setA.contains(listB.get(i))) {
        return listB.get(i);
      }
    }
    return null;
  }
}
