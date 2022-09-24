public class FloorAndCiel {
    static int findFloor(int[] arr, int x) {
        int start = 0, last = arr.length, mid, floor = -1;

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

    static int findCiel(int[] arr, int x) {
        int start = 0, end = arr.length - 1, mid, ciel = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x) {
                ciel = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ciel;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,8,10,11,12,19};
        int x = 5;

        System.out.println(findFloor(arr, x));
        System.out.println(findCiel(arr, x));
    }
}
