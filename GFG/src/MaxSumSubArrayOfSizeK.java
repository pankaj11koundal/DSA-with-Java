import java.util.ArrayList;

public class MaxSumSubArrayOfSizeK {
    static int maximumSumSubarray(ArrayList<Integer> arr, int k) {
        int i = 0, j = 0, sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (j < arr.size()) {
            sum += arr.get(j);
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr.get(i);
                i++;
            }
            j++;
        }

        return maxSum;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(100);
        arr.add(200);
        arr.add(300);
        arr.add(400);
        int k = 2;

        System.out.println(maximumSumSubarray(arr, k));
    }
}
