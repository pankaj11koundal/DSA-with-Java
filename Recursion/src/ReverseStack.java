// Java program to reverse the stack using recursion without using any extra space

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    static Scanner sc = new Scanner(System.in);

    static void insertElement(Stack<Integer> st, Integer ele) {
        if (st.empty())
            st.push(ele);
        else {
            Integer temp = st.pop();
            insertElement(st, ele);
            st.push(temp);
        }
    }

    static void reverseStack(Stack<Integer> st) {
        if (st.size() > 1) {
            Integer ele = st.pop();
            reverseStack(st);
            insertElement(st, ele);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int n;

        System.out.print("Enter the number of elements in the stack: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++)
            st.push(sc.nextInt());

        reverseStack(st);

        System.out.println("Stack after reversing: ");
        for(Integer element: st)
            System.out.print(element + " ");
    }
}
