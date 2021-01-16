package leetcode.p0394;

import java.util.Stack;

class Solution {

  public String decodeString(String s) {
    StringBuilder result = new StringBuilder();

    Stack<StringBuilder> resStack = new Stack<>();
    Stack<Integer> countStack = new Stack<>();

    int idx = 0;
    while(idx < s.length()) {
      char c = s.charAt(idx);
      if(Character.isDigit(c)) {
        int num = 0;
        while(Character.isDigit(s.charAt(idx))) {
          num = 10 * num + s.charAt(idx) - '0';
          idx++;
        }
        countStack.push(num);
      } else if(c == '[') {
        resStack.push(result);
        result = new StringBuilder();
        idx++;
      } else if(c == ']') {
        int count = countStack.pop();
        StringBuilder temp = resStack.pop();
        for(int i = 0; i < count; i++) {
          temp.append(result.toString());
        }
        result = temp;
        idx++;
      } else {
        result.append(c);
        idx++;
      }
    }
    return result.toString();
  }
}