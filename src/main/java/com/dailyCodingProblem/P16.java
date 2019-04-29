package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//This problem was asked by Twitter.
//
//    You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
//
//    record(order_id): adds the order_id to the log
//    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
//    You should be as efficient with time and space as possible.
public class P16 {

  private Map<Integer, String> orders = new HashMap<Integer, String>();
  private int length = 0;

  public void record(String order_id) {
    orders.put(length, order_id);
    this.length = this.length + 1;
  }

  public String getLast(int i) {
    return orders.get(length - i - 1);
  }

}
