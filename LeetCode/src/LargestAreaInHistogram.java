// Java program to find the maximum area in the histogram

import java.util.Stack;

public class LargestAreaInHistogram {static class stack {
    int height;
    int index;

    stack(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

    static int[] nGR(int[] histograms) {
        int[] arr = new int[histograms.length];
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

    static int[] nGL(int[] arr) {
        int[] ar = new int[arr.length];
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

    static int largestRectangleArea(int[] histograms)
    {
        int n = histograms.length;
        int maxArea = Integer.MIN_VALUE;
        int[] left = nGL(histograms);
        int[] right = nGR(histograms);
        for (int i = 0; i < n; i++)
            System.out.print(left[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(right[i] + " ");


        for (int i = 0; i < histograms.length; i++)
            maxArea = Math.max((right[i] - left[i] - 1) * histograms[i], maxArea);

        return maxArea;
    }

    public static void main(String[] args) {
        int []histograms = {9, 10, 4, 10, 4, 5, 16};

        System.out.println("Area of the largest histogram / maximum area of histogram is " + largestRectangleArea(histograms));
    }
}
