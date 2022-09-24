public class SubsetSumProblem {
    static Boolean isSubsetSum(int N, int []arr, int sum){
        boolean [][]t = new boolean[N + 1][sum + 1];

        for (int i = 0; i < N + 1; i++)
            t[i][0] = true;

        for (int j = 1; j < N + 1; j++)
            t[0][j] = false;

        for (int i = 1; i < arr.length + 1; i++)
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];

                else
                    t[i][j] = t[i - 1][j];
            }

        return t[N][sum];

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum =  121;

        System.out.println(isSubsetSum(arr.length, arr, sum));
    }
}
