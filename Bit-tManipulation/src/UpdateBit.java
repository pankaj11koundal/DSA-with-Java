// To update the ith position of the bit of a given number n by either given bit value 0 or 1.

import java.util.Scanner;

public class UpdateBit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int num, i, bit;
        System.out.print("Enter the number: ");
        num = sc.nextInt();

        System.out.print("Enter the position at which you want to update the bit: ");
        i = sc.nextInt();

        System.out.print("Enter the bit you want to update either 0 or 1: ");
        bit = sc.nextInt();

        num = (~(1 << i) & num);
        System.out.println("After updating the specified bit at specified position: " + ((bit << i) | num));
    }
}
