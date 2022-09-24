public class MergeSort {
    static class Solution {
        void merging(int[] arr, int low, int mid, int high) {
            int n1 = mid - low + 1, n2 = high - mid;
            int[] left = new int[n1];
            int[] right = new int[n2];

            for (int i = 0; i < n1; i++)
                left[i] = arr[low + i];

            for (int i = 0; i < n2; i++) {
                right[i] = arr[mid + i + 1];
            }

            int i = 0, j = 0, k = low;

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
        }
        void mergeSorting(int[] arr, int low, int high) {

            if (low < high) {
                int mid = (low) + (high - low) / 2;
                mergeSorting(arr, low, mid);
                mergeSorting(arr, mid + 1, high);
                merging(arr, low, mid, high);
            }

        }
        void mergeSort(int[] arr, int n) {
            int low = 0, high = n - 1;
            mergeSorting(arr, low, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        int n = arr.length;

        for (int ele: arr) System.out.print(ele + " ");
        System.out.println();
        Solution s = new Solution();
        s.mergeSort(arr, n);

        for (int ele: arr) System.out.print(ele + " ");
    }
}
