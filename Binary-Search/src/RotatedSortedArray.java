// Java program to find the number of times an sorted array is rotated.
// [11, 12, 15, 16, 2, 5, 6, 8]
// OP: 4

public class RotatedSortedArray {
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

    static int binarySearch(int[] nums, int target, int start, int end) {
        int low = start, high = end - 1, mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    static int search(int[] nums, int target) {
        int pos = numberOfTimesArrayRotated(nums, nums.length);

        if (nums[pos] == target)
            return pos;

        int left = binarySearch(nums, target, 0, pos);
        int right = binarySearch(nums, target, pos + 1, nums.length);

        if (left != -1)
            return left;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {15, 16, 17, 18, 19, 11, 12, 13, 14};
        int target = 11;
        System.out.println(search(arr, target));
    }
}
