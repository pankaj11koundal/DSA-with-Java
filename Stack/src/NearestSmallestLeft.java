// Java program to find the nearest smallest element on right

import java.util.Stack;

public class NearestSmallestLeft {
    static int[] nearestSmallestLeft(int []arr) {
        int []ar = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        ar[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (!st.empty() && arr[i] <= st.peek())
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
        int []ar = nearestSmallestLeft(arr);
        for (Integer ele :ar) {
            System.out.print(ele + " ");
        }
    }
}
