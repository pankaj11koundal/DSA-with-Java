// A number is given n and we have to set bit at ith position. To set bit means updating the bit value by 1.

import java.util.Scanner;

public class SetBit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int num, i;
        System.out.print("Enter the number: ");
        num = sc.nextInt();

        System.out.print("Enter the bit you want to set: ");
        i = sc.nextInt();

        System.out.println("The number is " + (1 << i | num));
    }
}
