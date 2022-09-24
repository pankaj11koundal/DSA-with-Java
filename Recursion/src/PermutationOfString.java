// Program to find all the permutations of the given string.

import java.util.Scanner;

public class PermutationOfString {
    static Scanner sc = new Scanner(System.in);

    static void printPermutationOfString(String str, String ans)
    {
        if (str.length() == 0)
            System.out.println(ans);
        else
        {
            for (int i = 0; i < str.length(); i++)
            {
                char ch = str.charAt(i);
                String ros = str.substring(0, i) + str.substring(i + 1);

                printPermutationOfString(ros, ans + ch);
            }
        }

    }

    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        printPermutationOfString(str, "");
    }

}
