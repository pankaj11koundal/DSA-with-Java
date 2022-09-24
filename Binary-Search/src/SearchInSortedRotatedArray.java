public class SearchInSortedRotatedArray {
    static int numberOfTimesArrayRotated(int[] arr, int n) {
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid > 0 && arr[mid] < arr[mid - 1])
                return mid;
            else if (mid + 1 < n && arr[mid] > arr[mid + 1])
                return mid + 1;
            else if (arr[start] <= arr[mid])
                start = mid + 1;
            else if (arr[end] >= arr[mid])
                end = mid - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {15, 16, 17, 18, 19, 11, 12, 13, 14};

        System.out.println(numberOfTimesArrayRotated(arr, arr.length));
    }
}
