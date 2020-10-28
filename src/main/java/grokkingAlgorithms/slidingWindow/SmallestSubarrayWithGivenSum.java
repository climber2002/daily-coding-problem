package grokkingAlgorithms.slidingWindow;

/**
 * Problem Statement #
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous
 * subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 *
 * Example 1:
 *
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 */
public class SmallestSubarrayWithGivenSum {

    public static int getAnswer(int[] arr, int s) {
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while(windowStart < arr.length) {
            while(windowStart < arr.length && sum < s) {
                sum += arr[windowStart++];
            }
            if(sum >= s) {
                answer = Math.min(windowStart - windowEnd, answer);
            }
            while(windowEnd < windowStart && sum >= s) {
                sum -= arr[windowEnd];
                if(sum >= s) {
                    answer = Math.min(windowStart - windowEnd - 1, answer);
                }
                windowEnd++;
            }
        }

        return answer;
    }
}
