import java.util.Scanner;

public class ReverseInteger {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long x, reverse = 0, rem;
        System.out.println("Enter the x: ");
        x = sc.nextLong();
        while (x != 0) {
            rem = x % 10;
            reverse = reverse * 10 + rem;
            x = x / 10;
        }

        if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(reverse);
    }
}
