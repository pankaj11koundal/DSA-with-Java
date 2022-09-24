import java.util.Scanner;

public class PowerOf2 {
    static Scanner sc = new Scanner(System.in);

    static boolean checkPowerOf2(int num)
    {
        return num != 0 && (num & (num - 1)) == 0;
    }

    public static void main(String[] args)
    {
        int num;
        System.out.print("Enter the number: ");
        num = sc.nextInt();

        if (checkPowerOf2(num))
            System.out.println("The given number is power of 2");
        else
            System.out.println("The given number is not a power of 2");
    }
}
