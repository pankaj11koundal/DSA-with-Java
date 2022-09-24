public class PeakElement {
    static int peakElement(int[] arr, int n) {
        int start = 0, end = n - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
                    return mid;
                else if (arr[mid] < arr[mid + 1])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else if (mid == 0)
                if (arr[mid] > arr[mid + 1])
                    return mid;
                else
                    return 1;
            else if (mid == n - 1 && arr[mid] > arr[mid - 1])
                return n - 1;
            else
                return n - 2;

        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {15, 3 ,19, 1, 7, 11, 1, 7, 7};

        System.out.println(peakElement(arr, arr.length));
    }
}
