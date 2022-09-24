// Java program to find the nearest smallest element on right

import java.util.Stack;

public class NearestSmallestRight {
    static int[] nearestSmallestRight(int []arr) {
        int []ar = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        ar[arr.length - 1] = -1;
        st.push(arr[arr.length -  1]);

        for (int i = arr.length - 2; i > -1; i--) {
            while (!st.empty() && arr[i] < st.peek())
                st.pop();

            if (st.empty())
                ar[i] = -1;
            else
                ar[i] = st.peek();

            st.push(arr[i]);
        }
        return ar;
    }

    public static void main(String[] args) {
        int []arr = {4, 5, 2, 10, 8};
        int []ar = nearestSmallestRight(arr);
        for (Integer ele :ar) {
            System.out.print(ele + " ");
        }
    }
}
