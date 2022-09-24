// Java program to find the maximum area in the histogram

import java.util.Stack;

public class MaximumHistogramArea {
        static class stack {
        long height;
        long index;

        stack(long height, long index) {
            this.height = height;
            this.index = index;
        }
    }

    static long[] nGR(long[] histograms) {
        long []arr = new long[histograms.length];
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

    static long[] nGL(long []arr) {
        long []ar = new long[arr.length];
        stack s = new stack(arr[0], 0);
        Stack<stack> st = new Stack<>();
        st.push(s);
        ar[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (!st.empty() && arr[i] <= st.peek().height)
                st.pop();

            if (st.empty())
                ar[i] = -1;
            else
                ar[i] = st.peek().index;

            s = new stack(arr[i], i);
            st.push(s);
        }
        return ar;
    }

    public static long getMaxArea(long []histograms, long n)
    {
        long maxArea = Long.MIN_VALUE;
        long []left = nGL(histograms);
        long [] right = nGR(histograms);
        for (int i = 0; i < n; i++)
            System.out.print(left[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(right[i] + " ");


        for (int i = 0; i < histograms.length; i++)
            maxArea = Long.max((right[i] - left[i] - 1) * histograms[i], maxArea);

        return maxArea;}

    public static void main(String[] args) {
        long []histograms = {9, 10, 4, 10, 4, 5, 16};
        int n = 7;

        System.out.println("Area of the largest histogram / maximum area of histogram is " + getMaxArea(histograms, n));
    }
}
