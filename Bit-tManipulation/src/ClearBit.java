// The clear bit or unset bit means the value of bit at given position should be update by 0.

import java.util.Scanner;

public class ClearBit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int num, i;
        System.out.print("Enter the number: ");
        num = sc.nextInt();

        System.out.print("Enter the position of the bit you wan to clear: ");
        i = sc.nextInt();

        System.out.println("The number after clearing the specified bit is " + ((~(1 << i)) & num));
    }
}
