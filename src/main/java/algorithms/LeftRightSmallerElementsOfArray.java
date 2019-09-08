package algorithms;

import java.util.Stack;

/**
 * For each element in an array, return the left and right index of the element that is smaller
 * than the element, if the smaller doesn't exist return -1
 *
 * For example:
 *
 *  arr = { 3, 4, 1, 5, 6, 2, 7 }
 *
 *  it should return
 *  {
 *      {-1, 2},
 *      {0, 2},
 *      {-1, -1},
 *      {2, 5},
 *      {3, 5},
 *      {2, -1},
 *      {5, -1}
 *  }
 */
public class LeftRightSmallerElementsOfArray {
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] result = new int[arr.length][];
        for(int i = 0; i < result.length; i++) {
            result[i] = new int[2];
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            int elementValue = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] > elementValue) {
                int topIndex = stack.pop();
                int topValue = arr[topIndex];
                result[topIndex][0] = stack.isEmpty() ? -1 : stack.peek();
                result[topIndex][1] = i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int topIndex = stack.pop();
            result[topIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            result[topIndex][1] = -1;
        }

        return result;
    }
}
