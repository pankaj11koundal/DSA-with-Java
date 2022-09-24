// Java program to implement the operation of deleting the middle element from stack.

import java.util.Scanner;
import java.util.Stack;

public class DeleteMiddleElementFromStack {
    static Scanner sc = new Scanner(System.in);

    static void deleteMiddleElementFromStack(Stack<Integer> st, int k) {
        if (st.size() == k)
            st.pop();
        else {
            Integer ele = st.pop();
            deleteMiddleElementFromStack(st, k);
            st.push(ele);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        int n;
        System.out.print("Enter the size of the stack: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            st.push(sc.nextInt());

        int k = st.size() / 2 + 1;

        deleteMiddleElementFromStack(st, k);

        for(Integer i: st) {
            System.out.print(i + " ");
        }
    }
}
