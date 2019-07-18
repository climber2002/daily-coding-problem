package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.LinkedList;

//Good morning! Here's your coding interview problem for today.
//
//    This problem was asked by Google.
//
//    Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
//
//    The list is very long, so making more than one pass is prohibitively expensive.
//
//    Do this in constant space and in one pass.
public class P26 {
  public static class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    public ArrayList<Integer> toArray() {
      if(next == null) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(value);
        return arr;
      } else {
        ArrayList<Integer> arr = this.next.toArray();
        arr.add(0, value);
        return arr;
      }
    }
  }

  public static Node removeLastKth(Node list, int k) {
    Node forward = list;
    int i = 0;
    while(i <= k) {
      forward = forward.next;
      i++;
    }

    Node current = list;

    while(forward != null) {
      forward = forward.next;
      current = current.next;
    }

    current.next = current.next.next;

    return list;
  }
}
