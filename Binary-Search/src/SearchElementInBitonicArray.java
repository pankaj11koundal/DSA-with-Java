public class SearchElementInBitonicArray {
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

    static int searchAscending(int[] nums, int target, int low, int high) {
        int mid;

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

    static int searchDescending(int[] nums, int target, int low, int high) {
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    static int search(int[] arr, int n, int ele) {
        int max = maxElementInBitonicArray(arr, n);
        if (ele == arr[max])
            return ele;
        else if (ele > arr[max])
            return searchAscending(arr, ele, 0, max);
        else if (ele < arr[max])
            return searchDescending(arr, ele, max, n);
        else
            return  -1;

    }

    public static void main(String[] args) {
        int []arr = {1, 3, 8, 12, 4, 2};
        System.out.println(search(arr, arr.length, 4));
    }
}
