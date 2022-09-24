public class CountOccurrenceOfXInSortedArray {
    static int firstOccurrence(int[] arr, int ele, int n) {
        int start = 0, end = n - 1, mid, pos = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (ele == arr[mid]) {
                pos = mid;
                end = mid - 1;
            } else if (arr[mid] > ele)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return pos;
    }

    static int lastOccurrence(int[] arr, int ele, int n) {
        int start = 0, end = n - 1, mid, pos = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (ele == arr[mid]) {
                pos = mid;
                start = mid + 1;
            } else if (arr[mid] > ele)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return pos;
    }

    public static void main(String[] args) {
        int [] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2, n = 7;
        int first = firstOccurrence(arr, x, n);
        int last = lastOccurrence(arr, x, n);
        if (first == -1 || last == -1)
            System.out.println(0);
        else
            System.out.println(last - first + 1);
    }
}
