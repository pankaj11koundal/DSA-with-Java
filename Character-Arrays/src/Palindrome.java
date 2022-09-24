import java.util.Scanner;

public class Palindrome {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        char []string = new char[100];
        boolean check = true;

        int size;
        System.out.print("Enter the size of the character array: ");
        size = sc.nextInt();


        System.out.print("Enter the character array: ");
        for (int i = 0; i < size; i++)
            string[i] = sc.next().charAt(0);

        for (int i = 0; i < size; i++)
            if (string[i] != string[size - 1 - i]){
                System.out.print(string[i] + " ");
                check = false;
                break;
            }

        if (check)
            System.out.println("The string is palindrome");
        else
            System.out.println("The string is not palindrome");
    }
}