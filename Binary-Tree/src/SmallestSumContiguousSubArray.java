public class SmallestSumContiguousSubArray {
    static class Solution {
        int smallestSum(int[] arr, int n) {
            int minSum = Integer.MAX_VALUE, currSum = 0;

            for (int i = 0; i < n; i++) {
                currSum += arr[i];

                if (currSum < minSum) minSum = currSum;

                if (currSum >= 0) currSum = 0;
            }

            return minSum;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {3,-4, 2,-3,-1, 7,-5};
        int[] arr = {1, 2, 3, 0};
        int n = arr.length;
        Solution s = new Solution();

        System.out.println(s.smallestSum(arr, n));
    }
}
