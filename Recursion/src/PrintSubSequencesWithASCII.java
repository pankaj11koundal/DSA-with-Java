// Program to print all the subsequences of given string with the ASCII codes of the characters.

import java.util.Scanner;

public class PrintSubSequencesWithASCII {
    static Scanner sc = new Scanner(System.in);

    static void printSubSequences(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
        } else {
            char ch = str.charAt(0);
            String ros = str.substring(1);

            printSubSequences(ros, ans + ch + (int)ch);
            printSubSequences(ros, ans + ch);
            printSubSequences(ros, ans);
        }
    }

    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        printSubSequences(str, "");
    }

}
