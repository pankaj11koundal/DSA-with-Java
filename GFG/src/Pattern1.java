// Print the pattern if n = 2
// 1*2*5*6
// --3*4

// Print the pattern if n = 3
// 1*2*3*10*11*12
// --4*5*8*9
// ----6*7

import java.util.ArrayList;
import java.util.List;

public class Pattern1 {
    static class Solution {
        List<String> getPattern(int n) {
            List<StringBuilder> l = new ArrayList<>();
            int ub = n * 4 - 1, mid = ub / 2, count = 1;

            for (int i = 0; i < n; i++) l.add(new StringBuilder());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < mid; j++) {
                    if (j < i * 2) l.get(i).append("-");
                    else if (j % 2 == 0) {
                        l.get(i).append(count);
                        count++;
                    } else l.get(i).append("*");
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = mid; j < ub; j++) {
                    if (j < ub - (i * 2)) {
                        if (j % 2 == 0) {
                            l.get(i).append(count);
                            count++;
                        } else l.get(i).append("*");
                    }
                }
            }
            List<String> list = new ArrayList<>();
            for (StringBuilder s: l) list.add(s.toString());
            return list;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> l;
        Solution s = new Solution();
        l = s.getPattern(n);
        System.out.println(l);
    }
}
