public class FirstAndLastOccurrenceOfElement {
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
        int []arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int ele = 5, n = 9;
        int first = firstOccurrence(arr, ele, n);
        int last = lastOccurrence(arr, ele, n);

        System.out.println(first + " " + last);
    }
}