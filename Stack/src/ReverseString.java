// Java program to reverse the string using stack.

import java.util.Scanner;
import java.util.*;

public class ReverseString {
    static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        str = "";

        StringBuilder strBuilder = new StringBuilder();
        while (!stack.empty()){
            strBuilder.append(stack.peek());
            stack.pop();
        }
        return  strBuilder.toString();
    }

    public static void main(String[] ags) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();

        str = reverseString(str);
        System.out.println(str);
    }
}
