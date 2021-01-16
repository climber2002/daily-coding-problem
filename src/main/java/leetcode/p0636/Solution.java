package leetcode.p0636;
import java.util.*;

class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    int lastTimestamp = -1;
    boolean isLastStart = false;

    for(String log : logs) {
      String[] fields = log.split(":");
      int id = Integer.parseInt(fields[0]);
      String tag = fields[1];
      int timestamp = Integer.parseInt(fields[2]);

      if(tag.equals("start")) {
        if(!stack.isEmpty() && lastTimestamp >= 0) {
          res[stack.peek()] += timestamp - lastTimestamp;
        }
        isLastStart = true;
        stack.push(id);
      } else if(tag.equals("end")) {
        if(isLastStart) {
          res[id] += timestamp - lastTimestamp + 1;
          stack.pop();
        } else {
          res[stack.peek()] += timestamp - lastTimestamp;
        }

        isLastStart = false;
      }
      lastTimestamp = timestamp;
    }
    return res;
  }
}
