public class ColorSort {
    static class Solution {
        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        void colorSort(int[] arr) {
            int low = 0, high = arr.length - 1, mid = 0;

            while (mid <= high) {
                if (arr[mid] == 0) {
                    swap(arr, mid, low);
                    low++;
                    mid++;
                } else if (arr[mid] == 1) {
                    mid++;
                } else {
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 0, 1, 2, 2, 1};
        Solution s = new Solution();
        s.colorSort(arr);
        for (int ele: arr)
            System.out.print(ele + " ");
    }
}
