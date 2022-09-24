import java.util.Scanner;

public class PrimeFactorization {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number whose prime factors you want to find: ");
        n = sc.nextInt();

        int []check = new int[n + 1];

        for (int i = 2; i < n + 1; i++)
            check[i] = i;

        for (int i = 2; i <= n; i++)
            if (check[i] == i)
                for (int j = i * i; j <= n; j += i)
                    if (check[j] == j)
                        check[j] = i;

        while(n != 1)
        {
            System.out.print(check[n] + " ");
            n = n / check[n];
        }

    }

}