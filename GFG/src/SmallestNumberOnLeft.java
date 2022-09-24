import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallestNumberOnLeft {
    static List<Integer> leftSmaller(int n, int []arr) {
        List<Integer> ar = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        ar.add(-1);
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            while (!st.empty() && arr[i] <= st.peek())
                st.pop();

            if (st.empty())
                ar.add(-1);
            else
                ar.add(st.peek());

            st.push(arr[i]);
        }
        return ar;
    }

    public static void main(String[] args) {
        int [] arr = {1, 5, 0, 3, 4, 5};
        int n = 6;

        System.out.println(leftSmaller(n, arr));
    }
}
