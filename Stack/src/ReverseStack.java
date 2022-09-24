// Java program to reverse the stack using recursion

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

    static void insertStack(Stack<Integer> st, int ele) {
        int topele;

        if (!st.empty()) {
            topele = st.pop();
            insertStack(st, ele);
            st.push(topele);
        }
        else
            st.push(ele);
    }

    static void reverseString(Stack<Integer> st) {
        int ele;
        if (!st.empty()) {
            ele = st.peek();
            st.pop();
            reverseString(st);
            insertStack(st, ele);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int ele; char choose;

        System.out.println("Enter the elements in the stack: ");
        do {
            System.out.println("Enter the element: ");
            ele = sc.nextInt();
            st.push(ele);

            System.out.print("Want to enter more elements: ");
            choose = sc.next().charAt(0);
        } while(choose == 'y' || choose == 'Y');

        System.out.println("The original stack is" + st);
        reverseString(st);
        System.out.println("The reversed stack is " + st);
    }
}
