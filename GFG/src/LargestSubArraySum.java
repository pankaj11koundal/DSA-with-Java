public class LargestSubArraySum {
    static class Solution {
        int largestSubArraySum(int[] arr, int n) {
            int max = Integer.MIN_VALUE;
            int sum;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    sum = 0;
                    for (int k = i; k < n - j; k++) {
                        sum += arr[k];
                    }
                    max = Math.max(max, sum);
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, -7, 2, 3};
        Solution s = new Solution();
        System.out.println(s.largestSubArraySum(arr, arr.length));
    }
}
