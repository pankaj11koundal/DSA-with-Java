import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumOptimizedApproach {
    static class Solution {
        List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> l = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int low = i + 1, high = nums.length - 1;

                    while (low < high) {
                        if (nums[low] + nums[high] == -nums[i]) {
                            List<Integer> temp = new LinkedList<>();
                            temp.add(nums[low]);
                            temp.add(nums[high]);
                            temp.add(nums[i]);
                            l.add(temp);

                            while (low < high && nums[low] == nums[low + 1]) low++;
                            while (low < high && nums[high] == nums[high - 1]) high--;
                            low++;
                            high--;
                        } else if (nums[low] + nums[high] < -nums[i]) low++;
                        else high--;
                    }
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution s = new Solution();

        System.out.println(s.threeSum(nums));
    }
}
