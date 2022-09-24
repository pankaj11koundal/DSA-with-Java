// Java program to find the nearest greatest element on the left side of the element
// Ex: [1, 3, 2, 4] -> [-1, -1, 3, -1]

import java.util.Stack;

public class NearestGreatestLeft {

    static int[] nearestGreatestLeft(int[] arr) {
        int []ar = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);
        ar[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (!st.empty() && arr[i] > st.peek())
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
        int []arr = {18, 4};
        int[] ar = nearestGreatestLeft(arr);
        for (Integer ele : ar) {
            System.out.print(ele + " ");
        }
    }
}
