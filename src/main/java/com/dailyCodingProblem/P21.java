package com.dailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//This problem was asked by Snapchat.
//
//    Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
//
//    For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
public final class P21 {

  public final static class Interval {
    public final int start;
    public final int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static int getNoOfRooms(Interval[] intervals) {
    List<List<Interval>> rooms = new ArrayList<List<Interval>>();

    for(Interval interval : intervals) {
      boolean added = false;
      for(int i = 0; i < rooms.size(); i++) {
        List<Interval> existingIntervals = rooms.get(i);
        if(!anyOverlap(interval, existingIntervals)) {
          existingIntervals.add(interval);
          added = true;
          break;
        }
      }

      if(!added) {
        rooms.add(new ArrayList<>(Arrays.asList(interval)));
      }
    }
    return rooms.size();
  }

  private static boolean anyOverlap(Interval interval, List<Interval> intervals) {
    for(Interval aInterval : intervals) {
      if(isOverlap(interval, aInterval)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isOverlap(Interval ia, Interval ib) {
    return !(ia.end < ib.start || ib.end < ia.start) ;
  }
}
