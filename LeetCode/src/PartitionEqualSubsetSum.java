public class PartitionEqualSubsetSum {
    private static boolean subsetSumSolver(int[] arr, int sum) {
        boolean [][]t = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++)
            t[i][0] = true;

        for (int j = 1; j < sum + 1; j++)
            t[0][j] = false;


        for (int i = 1; i < arr.length + 1; i++)
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];

                else
                    t[i][j] = t[i - 1][j];
            }

        return t[arr.length][sum];
    }

    public static boolean canPartition(int[] nums) {
        int add = 0;
        for (int num : nums) add += num;

        if (add % 2 != 0)
            return false;
        else
            return subsetSumSolver(nums, add / 2);
    }

    public static void main(String[] args) {
        int []nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
