public class ReversePairs {
    static int merging(int[] arr, int low, int mid, int high) {
        int c = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > (long)arr[j] * 2) {
                j++;
            }
            c += j - (mid + 1);
        }

        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }

        int i = 0, k = low;
        j = 0;
        while (i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return c;
    }
    static int mergeSorting(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low) + (high - low) / 2;
            int c = mergeSorting(arr, low, mid);
            c += mergeSorting(arr, mid + 1, high);
            c += merging(arr, low, mid, high);
            return c;
        }
        return 0;
    }

    static class Solution {
        int reversePairs(int[] arr, int n) {
            int low = 0, high = n - 1;
            return mergeSorting(arr, low, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        Solution s = new Solution();
        System.out.println(s.reversePairs(arr, arr.length));
    }

}
