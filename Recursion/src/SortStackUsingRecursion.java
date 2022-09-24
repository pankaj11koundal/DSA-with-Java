// Java program to implement the sorting of stack using recursion.

import java.util.Scanner;
import java.util.Stack;

public class SortStackUsingRecursion {
    static Scanner sc = new Scanner(System.in);

    static void pushElement(Stack<Integer> st, Integer ele) {
        if (st.empty() || st.peek() <= ele)
            st.push(ele);
        else {
            Integer temp = st.pop();
            pushElement(st, ele);
            st.push(temp);
        }
    }

    static void sortStackUsingRecursion(Stack<Integer> st) {
        if (st.size() != 1) {
            Integer ele = st.pop();
            sortStackUsingRecursion(st);
            pushElement(st, ele);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        int n;
        System.out.println("Enter the size of the stack: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        sortStackUsingRecursion(st);

        for (Integer element :st) {
            System.out.print(element + " ");
        }
    }
}
