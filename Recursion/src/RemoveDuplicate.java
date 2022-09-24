// Program to remove the duplicate characters from string.

import java.util.Scanner;

public class RemoveDuplicate {
    static Scanner sc = new Scanner(System.in);

    static String removeDup(String str)
    {
        if (str.length() == 1)
            return str;

        char ch = str.charAt(0);
        String ans = removeDup(str.substring(1));

        if (ch == ans.charAt(0))
            return ans;
        else
            return ch + ans;
    }

    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        System.out.println(removeDup(str));
    }

}
