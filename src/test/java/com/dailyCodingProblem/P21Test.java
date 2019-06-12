package com.dailyCodingProblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P21Test {

  @Test
  public void testGetNoOfRooms() {
    //    [(30, 75), (0, 50), (60, 150)]
    P21.Interval[] intervals = new P21.Interval[] { new P21.Interval(30, 75),
                                                    new P21.Interval(0, 50),
                                                    new P21.Interval(60, 150) };

    assertEquals(2, P21.getNoOfRooms(intervals));
  }
}
