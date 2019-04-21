package com.dailyCodingProblem;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//This problem was asked by Apple.
//
//    Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
public class P10 {

  private final static ScheduledExecutorService scheduleService = Executors.newScheduledThreadPool(2);


  public static void schedule(Callable f, int milliseconds) {
    scheduleService.schedule(f, milliseconds, TimeUnit.MILLISECONDS);
  }

}
