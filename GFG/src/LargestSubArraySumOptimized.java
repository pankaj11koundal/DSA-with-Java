import java.util.ArrayList;

public class LargestSubArraySumOptimized {
    static class Solution {
        ArrayList<Integer> largestSubArraySum(int[] arr, int n) {
            int sum = 0, max = Integer.MIN_VALUE;
            ArrayList<Integer> maxSub = new ArrayList<>();
            ArrayList<Integer> subArray = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (arr[i] < 0 ) {
                    if (sum > max) {
                        max = sum;
                        maxSub.clear();
                        maxSub.addAll(subArray);
                    }
                    sum = 0;
                    subArray.clear();
                } else {
                    sum += arr[i];
                    subArray.add(arr[i]);
                }
            }

            if (maxSub.isEmpty() && subArray.isEmpty()) {
                maxSub.add(-1);
            } else if (max < sum) maxSub = subArray;
            return maxSub;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {-4, -7, -6, 0, -19, 2, -7, -18, -17, 7, -9, -1, 8, 19, -16, -5, 3, 8, 5, 11, 14, 17, -7, 11, -5 ,4, 2, -17, -13, -19, -8 ,0, 3, -12, -15,-13, -15, 4, 0, -6, 16, -17, 0};
//        int[] arr = {-5, -7, -7, -17, -14, -15, -14};
        int[] arr = {1, 2, 3, 4};
//        int[] arr = {-4, 8, 13, 5, -8, -18,-14, -4, -15, 7, 2, 2,20, 3};
        Solution s = new Solution();
        System.out.println(s.largestSubArraySum(arr, arr.length));
    }
}
