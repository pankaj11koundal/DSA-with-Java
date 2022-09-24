import java.util.Scanner;

public class CountNumber1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int num, count = 0;
        System.out.print("Enter the number: ");
        num = sc.nextInt();
          do {
              num = num & (num - 1);
              count++;
          } while (num != 0);

        System.out.println("the number of one bit in the given number is " + count);
    }
}
