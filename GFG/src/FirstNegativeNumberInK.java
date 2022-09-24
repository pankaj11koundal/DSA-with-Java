// Java program to find the first negative number in each window of size k

import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegativeNumberInK {
    static Scanner sc = new Scanner(System.in);

    static long[] firstNegativeElement(long[] arr, int n, int k) {
        long[] negativeElements = new long[n];
        LinkedList<Long> q = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] < 0)
                q.add(arr[j]);

            if (j - i + 1 == k) {
                if (q.isEmpty())
                    negativeElements[i] = (long) 0;
                else {
                    negativeElements[0] = q.peek();
                    if (!q.isEmpty() && q.peek() == arr[i])
                        q.remove();
                }
                i++;
            }
            j++;
        }
        return negativeElements;
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        long[] arr = new long[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        int k;
        System.out.print("Enter the size of the window: ");
        k = sc.nextInt();

        long[] negativeElement = firstNegativeElement(arr, n, k);

        for (Long element : negativeElement)
            System.out.print(element + " ");
    }
}
