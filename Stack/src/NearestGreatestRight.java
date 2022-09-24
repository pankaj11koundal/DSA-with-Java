// Java program to find the greatest number closest to right
// Ex: [1, 3, 2, 4] = [3, 4, 4, -1]

import java.util.Stack;

public class NearestGreatestRight {
    static int [] nearestGreatestRight(int []arr) {
        Stack<Integer> st = new Stack<>();
        int []ar = new int[arr.length];

        ar[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);

        for (int i = arr.length - 2; i > -1; i--) {
            while (!st.empty() && arr[i] >= st.peek())
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
        int []arr = {1, 3, 2, 4};
        int []ar = nearestGreatestRight(arr);
        for (Integer i : ar) {
            System.out.print(i + " ");
        }
    }
}
