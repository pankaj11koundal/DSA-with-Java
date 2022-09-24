// Maximum sub-array using Kadane's Algorithm

public class MaximumSubArray {
    static class Solution {
        int maximumSubArray (int[] arr) {
            int sum = 0, max = Integer.MIN_VALUE;
            for (int j : arr) {
                sum += j;
                if (max < sum) max = sum;

                if (sum < 0) sum = 0;
            }
            return max;
        }
    }
    public static void main(String[] args) {
        int[] arr = {-2,-1,-3,-5,0};
        Solution s = new Solution();
        System.out.print(s.maximumSubArray(arr));
    }
}
