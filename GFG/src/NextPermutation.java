import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    static class Solution {
        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        void reverse(int[] arr, int i, int j) {
            int temp;
            while (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        List<Integer> nextPermutation(int[] arr, int n) {
            int i = arr.length - 2;
            List<Integer> l = new ArrayList<>();
            while (i >= 0 && arr[i] >= arr[i + 1]) i--;

            if (i > 0) {
                int j = arr.length - 1;
                while(arr[j] < arr[i]) j--;
                swap(arr, i, j);
            }

            reverse(arr, i + 1, n - 1);
            for (Integer ele : arr) {
                l.add(ele);
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 5, 4};
        int n = arr.length;

        Solution s = new Solution();
        System.out.println(s.nextPermutation(arr, n));
    }
}
