import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblemBruteForce {
    static class Solution {
        List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> s = new HashSet<>();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                        }
                    }

                    if (!temp.isEmpty()) s.add(temp);
                }
            }

            List<List<Integer>> l = new ArrayList<>(s);

            return l;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();

        System.out.println(s.threeSum(nums));
    }

}
