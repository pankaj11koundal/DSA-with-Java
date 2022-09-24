public class CountInversion {
    static class Solution {
        static class Count {
            int count = 0;
        }
        void merging(int[] arr, int low, int mid, int high, Count c) {
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
                    c.count += n1 - i;
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
        void mergeSorting(int[] arr, int low, int high, Count c) {

            if (low < high) {
                int mid = (low) + (high - low) / 2;
                mergeSorting(arr, low, mid, c);
                mergeSorting(arr, mid + 1, high, c);
                merging(arr, low, mid, high, c);
            }
        }
        int countInversion(int[] arr, int n) {
            int low = 0, high = n - 1;
            Count c = new Count();
            mergeSorting(arr, low, high, c);
            return c.count;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
        int n = arr.length;

        for (int ele: arr) System.out.print(ele + " ");
        System.out.println();
        Solution s = new Solution();
        int count = s.countInversion(arr, n);

        for (int ele: arr) System.out.print(ele + " ");
        System.out.println();
        System.out.println(count);
    }
}
