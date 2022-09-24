import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ar = new ArrayList<>();

            if (intervals.length == 0) return ar.toArray(new int[0][]);

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int start = intervals[0][0], end = intervals[0][1];

            for (int[] i: intervals) {
                if (i[0] <= end)
                    end = Math.max(i[1], end);
                else {
                    ar.add(new int[]{start, end});
                    start = i[0];
                    end = i[1];
                }
            }

            ar.add(new int[]{start, end});

            return ar.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8,10}, {15,18}};
        Solution s = new Solution();
        int[][] mergeIntervals = s.merge(intervals);

        for (int[] ar: mergeIntervals) {
            for (int ele :ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
