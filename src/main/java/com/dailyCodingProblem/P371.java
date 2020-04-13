package com.dailyCodingProblem;

import java.util.*;

public class P371 {

  public static class Op {
    private boolean positive;
    private String variable;

    public Op(boolean positive, String variable) {
      this.positive = positive;
      this.variable = variable;
    }

    public boolean isPositive() {
      return this.positive;
    }

    public boolean isNegative() {
      return !this.positive;
    }

    public String getVariable() {
      return this.variable;
    }
  }

  public static class Expression {
    private Map<String, Op> variables;
    private int constant;

    public Expression(String expression) {
      this.variables = new HashMap<>();
      this.constant = 0;

      String[] splitted = expression.split("=");
      String left = splitted[0];
      String right = splitted[1];

      String[] leftOps = getOps(left);
      for(String op : leftOps) {
        processOp(op, true);
      }

      String[] rightOps = getOps(right);
      for(String op : rightOps) {
        processOp(op, false);
      }
    }

    public Map<String, Op> getVariables() {
      return this.variables;
    }

    public int getConstant() {
      return this.constant;
    }

    private void processOp(String op, boolean positive) {
      String trimmed = op.trim();
      try {
        int num = Integer.parseInt(trimmed);
        if(positive) {
          this.constant += num;
        } else {
          this.constant -= num;
        }
      } catch (NumberFormatException ex) {
        variables.put(trimmed, new Op(positive, trimmed));
      }
    }

    private String[] getOps(String exp) {
      return exp.split("\\+");
    }
  }

  public static class Expressions {
    private Set<Expression> expressions;

    public Expressions(String[] expressionStrings) {
      this.expressions = new HashSet<>();

      for(String exp : expressionStrings) {
        expressions.add(new Expression(exp));
      }
    }


  }
}
