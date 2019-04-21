package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class P11 {

  public static String[] getStringsWithPrefix(String prefix, String[] strings) {
    int prefixLength = prefix.length();

    List<String> res = new ArrayList<String>();
    for(int i = 0; i < strings.length; i++) {
      if(strings[i].substring(0, prefixLength).equals(prefix)) {
        res.add(strings[i]);
      }
    }

    return res.toArray(new String[0]);
  }
}
