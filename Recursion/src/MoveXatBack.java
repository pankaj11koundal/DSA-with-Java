// Program to move all the 'x' to the back of the string.

import java.util.Scanner;

public class MoveXatBack {
    static Scanner sc = new Scanner(System.in);

    static String moveX(String str) {
        if (str.length() == 1)
            return str;

        char ch = str.charAt(0);
        String ans = moveX(str.substring(1));

        if (ch == 'x')
            return ans + ch;
        else
            return ch + ans;
    }

    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        System.out.println(moveX(str));;
    }
}
