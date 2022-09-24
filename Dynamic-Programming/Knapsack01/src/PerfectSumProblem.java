class PerfectSumProblem {
    private static int perfectSum(int []arr, int n, int sum) {
        int [][] t = new int[n+1][sum + 1];

        for (int i = 0; i < n + 1; i++)
            t[i][0] = 1;
        for (int j = 1; j < sum + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j] ;
                } else
                    t[i][j] = t[i - 1][j];
            }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int []arr ={3,5,7,8,9,10,11};
        int sum = 1000;

        System.out.println(perfectSum(arr, arr.length, sum));

    }
}