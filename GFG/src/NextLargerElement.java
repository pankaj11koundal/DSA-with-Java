import java.util.Stack;

public class NextLargerElement {
    static long [] nearestGreatestRight(long []arr, int n) {
        Stack<Long> st = new Stack<>();
        long []ar = new long[arr.length];

        ar[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i > -1; i--) {
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
        long []arr = {1, 3, 2, 4};
        int n = 4;
        long []ar = nearestGreatestRight(arr, n);
        for (long i : ar) {
            System.out.print(i + " ");
        }
    }
}
