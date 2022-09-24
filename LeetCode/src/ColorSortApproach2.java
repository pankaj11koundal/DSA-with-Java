public class ColorSortApproach2 {
    static class Solution {
        void colorSort(int[] arr) {
            int a = 0, b = 0, c = 0;
            for (int j : arr) {
                if (j == 0) a++;
                else if (j == 1) b++;
                else c++;
            }

            for (int i = 0; i < arr.length; i++) {
                if (a > 0) {
                    arr[i] = 0;
                    a--;
                } else if (b > 0) {
                    arr[i] = 1;
                    b--;
                } else {
                    arr[i] = 2;
                    c--;
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
