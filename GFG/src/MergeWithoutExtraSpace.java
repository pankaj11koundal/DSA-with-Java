import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeWithoutExtraSpace {
    static class Solution {
        void swap(int[] a, int[] b, int j, int k) {
            int temp = a[k];
            a[k] = b[j];
            b[j] = temp;
        }
        void merge(int[] a, int[] b, int n, int m) {
            int i = 0, j = 0, k = n - 1;
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();
            while(i <= k && j < m) {
                if (a[i] < b[j]) i++;
                else {
                    swap(a, b, j, k);
                    j++;
                    k--;
                }
            }

            for (int ele:a) {
                aList.add(ele);
            }
            for (int ele:b) {
                bList.add(ele);
            }

            Collections.sort(aList);
            Collections.sort(bList);

            for (i = 0; i < n; i++) {
                a[i] = aList.get(i);
            }

            for (j = 0; j < m; j++) {
                b[j] = bList.get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 35};
        int[] b = {6, 9, 13, 15, 20, 25, 29, 46};
        int n = a.length, m = b.length;

        Solution s = new Solution();
        s.merge(a, b, n, m);

        for (int ele : a) {
            System.out.print(ele + " ");
        }

        for (int ele: b) {
            System.out.print(ele + " ");
        }
    }
}
