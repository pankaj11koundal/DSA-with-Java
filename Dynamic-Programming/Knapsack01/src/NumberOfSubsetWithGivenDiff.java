public class NumberOfSubsetWithGivenDiff {

    static int count_zeros_till_index(int []arr,int i)
    {
        int count=0;
        for(int j=0;j<i;j++)
        {
            if(arr[j]==0)
                count++;
        }
        return count;
    }

    private static int perfectSum(int []arr, int n, int sum) {
        int [][] t = new int[n+1][sum + 1];

        for (int i = 0; i < n + 1; i++)
            t[i][0] = (int)Math.pow(2, count_zeros_till_index(arr, i));
        for (int j = 1; j < sum + 1; j++)
            t[0][j] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = (t[i - 1][j - arr[i - 1]] + t[i - 1][j])%1000000007 ;
                } else
                    t[i][j] = t[i - 1][j];
            }
        return t[n][sum];
    }

    private static int findNumberOfSubsetWithGivenDiff(int[] arr, int diff) {
        int range = 0;
        for (int value: arr) range += value;

        int sum = (range + diff) / 2;

        return perfectSum(arr, arr.length, sum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 3;

        System.out.println(findNumberOfSubsetWithGivenDiff(arr, diff));
    }
}
