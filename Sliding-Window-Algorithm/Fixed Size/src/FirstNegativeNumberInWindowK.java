// Java program to find the first negative number in each window of size k

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegativeNumberInWindowK {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> firstNegativeElement(int[] arr, int n, int k) {
        ArrayList<Integer> negativeElements = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] < 0)
                q.add(arr[j]);

            if (j - i + 1 == k) {
                if (q.isEmpty())
                    negativeElements.add(0);
                else {
                    negativeElements.add(q.peek());
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

        int[] arr = new int[n];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k;
        System.out.print("Enter the size of the window: ");
        k = sc.nextInt();

        ArrayList<Integer> negativeElement = firstNegativeElement(arr, n, k);

        for (Integer element : negativeElement)
            System.out.print(element + " ");
    }
}
