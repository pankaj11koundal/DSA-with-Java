public class FindDuplicate {
    static class Solution {
        int findDuplicate(int[] nums) {
            boolean[] visited = new boolean[nums.length + 1];
            int duplicate = -1;
            for (int num : nums) {
                if (!visited[num]) visited[num] = true;
                else {
                    duplicate = num;
                    break;
                }
            }
            return duplicate;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        Solution s = new Solution();

        System.out.println(s.findDuplicate(nums));
    }
}
