public class SubsetSumProblem {
    private static boolean subsetSumSolver(int[] arr, int sum) {
        boolean [][]t = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++)
            t[i][0] = true;

        for (int j = 1; j < arr.length + 1; j++)
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

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum =  121;

        System.out.println(subsetSumSolver(arr, sum));
    }
}
