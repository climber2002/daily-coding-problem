package grokkingAlgorithms.slidingWindow;

public class MaxSumSubarrayOfSizeK {
    public static int getMaxOfSubarray(int[] arr, int k) {
        if(arr.length < k) {
            throw new IllegalArgumentException();
        }
        int frontIdx = 0;
        int endIdx = 0;
        int sum = 0;
        while(frontIdx - endIdx < k) {
            sum += arr[frontIdx++];
        }
        int res = sum;
        while(frontIdx < arr.length) {
            sum += arr[frontIdx++];
            sum -= arr[endIdx++];
            res = Math.max(res, sum);
        }
        return res;
    }
}
