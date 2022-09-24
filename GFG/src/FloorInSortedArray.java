public class FloorInSortedArray {
    static int findFloor(long[] arr, int n, long x) {
        int start = 0, last = n - 1, mid, floor = -1;

        while (start <= last) {
            mid = start + (last - start) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x) {
                floor = mid;
                start = mid + 1;
            } else
                last = mid - 1;
        }
        return floor;
    }

    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19};
        long x = 5;

        System.out.println(findFloor(arr, arr.length, x));
    }
}
