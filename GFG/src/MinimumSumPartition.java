public class MinimumSumPartition {

    private static boolean [][]t;

    private static void subsetSumSolver(int[] arr, int sum) {
        t = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++)
            t[i][0] = true;

        for (int j = 1; j < arr.length + 1; j++)
            t[0][j] = false;


        for (int i = 1; i < arr.length + 1; i++)
            for (int j = 1; j < sum + 1; j++)
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];

                else
                    t[i][j] = t[i - 1][j];
    }

    public static int minDifference(int []arr, int n)
    {
        int min = Integer.MAX_VALUE;

        int range = 0;
        for (int value : arr) range += value;

        subsetSumSolver(arr, range);

        for (int j = 0; j < range + 1; j++) {
            if (t[n][j])
                min = Math.min(Math.abs(range - 2 * j), min);
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {-36, 36};

        System.out.println(minDifference(arr, arr.length));
    }
}
