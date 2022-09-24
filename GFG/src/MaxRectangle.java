// Java program to to find the maximum area in the given Binary Matrix
// ex: {[0, 1, 1, 0],
//      [1, 1, 1, 1],
//      [1, 1, 1, 1],
//      [1, 1, 1, 0]}

import java.util.*;

public class MaxRectangle {

    static class stack {
        int height;
        int index;

        stack(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    static int[] nGR(int[] histograms) {
        int []arr = new int[histograms.length];
        int size = histograms.length;
        Stack<stack> st = new Stack<>();

        arr[size - 1] = size;
        stack s = new stack(histograms[size - 1], size - 1);
        st.push(s);

        for (int i = size - 2; i >= 0; i--) {
            while (!st.isEmpty() && histograms[i] <= st.peek().height)
                st.pop();

            if (st.isEmpty())
                arr[i] = size;
            else
                arr[i] = st.peek().index;

            s = new stack(histograms[i], i);
            st.push(s);
        }

        return arr;
    }

    static int[] nGL(int []histograms) {
        int []ar = new int[histograms.length];
        stack s = new stack(histograms[0], 0);
        Stack<stack> st = new Stack<>();
        st.push(s);
        ar[0] = -1;

        for (int i = 1; i < histograms.length; i++) {
            while (!st.empty() && histograms[i] <= st.peek().height)
                st.pop();

            if (st.empty())
                ar[i] = -1;
            else
                ar[i] = st.peek().index;

            s = new stack(histograms[i], i);
            st.push(s);
        }
        return ar;
    }

    static int mah(int []histograms) {
        int maxArea = Integer.MIN_VALUE;
        int[] left = nGL(histograms);

        int[] right = nGR(histograms);
        for (int i = 0; i < histograms.length; i++)
            maxArea = Integer.max((right[i] - left[i] - 1) * histograms[i], maxArea);

        return maxArea;
    }

    static int maxArea(int [][]bMatrix, int n, int m) {
        int []arr = new int[m];
        for (int j = 0; j < m; j++) {
            arr[j] = bMatrix[0][j];
        }

        int maxArea = mah(arr);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bMatrix[i][j] == 0)
                    arr[j] = 0;
                else
                    arr[j] = bMatrix[i][j] + arr[j];

            }
            maxArea = Integer.max(maxArea, mah(arr));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [][]bMatrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        int n, m;
        System.out.println("Enter the dimension of the binary matrix: ");
        n = bMatrix.length;
        m = bMatrix[0].length;

        System.out.println("The maximum area in the binary matrix is " + maxArea(bMatrix, n, m));
    }
}
