import java.util.Scanner;

public class SieveOfEratosthenes {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number upto where you want to find the prime numbers: ");
        n = sc.nextInt();

        int []check = new int[n + 1];
        for (int i = 2 ; i <= n; i++)
            for (int j = i * i; j <= n; j += i)
                if (check[j] == 0)
                    check[j] = 1;

        for (int i = 0; i < n + 1; i++) {
            if (check[i] == 0)
                System.out.print(i + " ");
        }
    }
}
