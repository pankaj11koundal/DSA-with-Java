import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    static class Solution {
        List<List<Integer>> pascalsTriangle(int n) {
            List<List<Integer>> l = new ArrayList<>();

            for (int i = 0; i < n; i++) l.add(new ArrayList<>());

            l.get(0).add(1);
            if (n > 1) {
                l.get(1).add(1);
                l.get(1).add(1);
            }

            for (int i = 2; i < n; i++) {
                l.get(i).add(1);
                for (int j = 1; j < i; j++) {
                    l.get(i).add(l.get(i - 1).get(j - 1) + l.get(i - 1).get(j));
                }
                l.get(i).add(1);
            }

            return l;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        List<List<Integer>> l = s.pascalsTriangle(n);
        for (List<Integer> list: l) {
            for (Integer ele: list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
