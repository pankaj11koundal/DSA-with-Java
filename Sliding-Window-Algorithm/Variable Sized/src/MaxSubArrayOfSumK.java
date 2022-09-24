// Find the size of the maximum sub array whose sum is k
// Ex: arr = [4, 1, 1, 1, 2, 3, 5], k = 5
// OP: 4

public class MaxSubArrayOfSumK {

    static int findSubArray(int[] arr, int k) {
        int maxSize = Integer.MIN_VALUE, i = 0, j = 0, sum = 0;

        while (j < arr.length) {
            sum += arr[j];

            while (sum > k) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) {
                maxSize = Math.max(maxSize, j - i + 1);
            }
            j++;
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int [] arr = {4, 1, 1, 1, 2, 3, 5};
        int k = 5;
        System.out.println("The size of the maximum sub array whose sum is " + findSubArray(arr, k));
    }

}
