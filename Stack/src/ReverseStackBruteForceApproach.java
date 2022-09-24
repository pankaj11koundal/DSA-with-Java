// Java program to reverse the stack brute force approach.

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackBruteForceApproach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>(), revs = new Stack<>();
        int ele;
        char choose;

        System.out.println("Enter the elements in the stack: ");
        do {
            System.out.println("Enter the element: ");
            ele = sc.nextInt();
            st.push(ele);

            System.out.print("Want to enter more elements: ");
            choose = sc.next().charAt(0);
        } while(choose == 'y' || choose == 'Y');

        System.out.println("The stack is: " + st);

        while (!st.empty()) {
            revs.push(st.peek());
            st.pop();
        }

        System.out.println("The reverse string is: " + revs);
    }
}
