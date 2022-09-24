// Program to replace the substring 'pi' from a string with "3.14".

import java.util.Scanner;

public class ReplacePi {
    static Scanner sc = new Scanner(System.in);

    static void replacePi(String str, int i)
    {
        if (i >= str.length())
            return ;
        else if(i == str.length() - 1){
            System.out.print(str.charAt(i));
            replacePi(str, i + 1);
        }
        else if (str.charAt(i) == 'p' && str.charAt(i + 1) == 'i') {
            System.out.print("3.14");
            replacePi(str, i + 2);
        }
        else {
            System.out.print(str.charAt(i));
            replacePi(str, i + 1);
        }
    }


    public static void main(String[] args)
    {
        String str;
        System.out.print("Enter the string: ");
        str = sc.next();

        replacePi(str, 0);
    }
}
