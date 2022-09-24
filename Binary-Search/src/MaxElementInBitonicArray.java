public class MaxElementInBitonicArray {
    static int maxElementInBitonicArray(int[] arr, int n) {
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid > 0 && mid < n - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                else if (arr[mid] < arr[mid + 1])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1])
                    return 0;
                else
                    return 1;
            } else if (mid == n - 1 && arr[mid] > arr[mid - 1])
                return n - 1;
            else
                return n - 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []arr = {1, 15, 25, 45, 42, 21, 17, 12, 11};
        System.out.println(maxElementInBitonicArray(arr, arr.length));
    }
}
