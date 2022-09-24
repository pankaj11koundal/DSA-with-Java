public class PartitionEqualSum {

    private static int subsetSumSolver(int[] arr, int sum) {
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

        if (t[arr.length][sum])
            return 1;
        else
            return 0;
    }

    static int equalPartition(int n, int arr[])
    {
        int add = 0;
        for (int i = 0; i < n; i++)
            add += arr[i];

        if (add % 2 != 0)
            return 0;
        else
            return subsetSumSolver(arr, add / 2);

    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 1};
        int n = 4;

        System.out.println(equalPartition(n, arr));
    }
}
