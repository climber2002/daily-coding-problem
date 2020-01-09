package com.dailyCodingProblem;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

public class P274Test {

  @Test
  public void testEval_simple() {
    assertEquals(2, P274.eval("2"));
  }

  @Test
  public void testEval_simpleOp() {
    assertEquals(5, P274.eval("2+3"));
    assertEquals(7, P274.eval("2 + (2 + 3)"));
  }

  @Test
  public void testEval_minus() {
    assertEquals(-5, P274.eval("2 - (4 + 3)"));
  }


  @Test
  public void testCalculateCurrentFrame_empty() {
    Stack<String> frame = new Stack<>();
    assertEquals(0, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame_one() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    assertEquals(3, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame_two() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    frame.push("+");
    frame.push("2");
    assertEquals(5, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame_minusTwo() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    frame.push("-");
    frame.push("2");
    assertEquals(-1, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame_moreThan10() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    frame.push("+");
    frame.push("22");
    assertEquals(25, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    frame.push("+");
    frame.push("2");
    frame.push("+");
    frame.push("1");

    assertEquals(6, P274.calculateCurrentFrame(frame));
  }

  @Test
  public void testCalculateCurrentFrame_minus() {
    Stack<String> frame = new Stack<>();
    frame.push("3");
    frame.push("+");
    frame.push("2");
    frame.push("+");
    frame.push("1");
    frame.push("-");

    assertEquals(4, P274.calculateCurrentFrame(frame));
  }
}