// Get bit means the value of the bit at ith position.

import java.util.Scanner;

public class GetBit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int num, i;
        System.out.print("Enter the number: ");
        num = sc.nextInt();

        System.out.print("Enter the bit number you want to get: ");
        i = sc.nextInt();

        if ((1 << i & num) == 0)
            System.out.println("The bit is " + 0);
        else
            System.out.println("The bit is " + 1);
    }
}
