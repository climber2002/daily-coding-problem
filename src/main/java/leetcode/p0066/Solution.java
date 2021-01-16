package leetcode.p0066;

class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 0;
    for(int i = digits.length - 1; i >= 0; i--) {
      if(i == digits.length - 1) {
        carry = (digits[i] + 1) > 9 ? 1 : 0;
        digits[i] = (digits[i] + 1) % 10;
      } else {
        if(carry == 0) {
          return digits;
        } else {
          int newCarry = (digits[i] + carry) > 9 ? 1 : 0;
          digits[i] = (digits[i] + carry) % 10;
          carry = newCarry;
        }
      }

    }

    if(carry == 0) {
      return digits;
    } else {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      for(int i = 0; i < digits.length; i++) {
        result[i + 1] = digits[i];
      }
      return result;
    }
  }
}
