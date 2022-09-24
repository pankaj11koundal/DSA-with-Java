import java.util.Scanner;

public class PrintSubsetUsingBits {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n;
        System.out.print("Enter the number of elements in the array: ");
        n = sc.nextInt();

        int [] arr = new int[n];
        System.out.println("Enter the elements in the array");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < (1 << n); i++)
        {
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) != 0)
                    System.out.print(arr[j] + " ");
            System.out.println();
        }
    }
}
