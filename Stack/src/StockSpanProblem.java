//Java Program to implement the stock span Problem
// Find out the number of consecutive days before where the stock value is less than today
// [100, 80, 60, 70, 60, 75, 85] = [1, 1, 1, 2, 1, 4, 5]

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    static Scanner sc = new Scanner(System.in);

    static class Stock {
        int value;
        int index;

        Stock(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int[] stockSpan(int[] arr) {
        int []ar = new int[arr.length];
        Stack<Stock> st = new Stack<>();
        Stock s = new Stock(arr[0], 0);
        ar[0] = -1;
        st.push(s);

        for (int i = 1 ; i < arr.length; i++) {
            while (!st.empty() && arr[i] > st.peek().value)
                st.pop();

            if (st.empty())
                ar[i] = -1;
            else
                ar[i] = st.peek().index;

            s = new Stock(arr[i], i);
            st.push(s);
        }
        return ar;
    }

    public static void main(String[] args) {
        int n;

        System.out.println("Enter the number of days: ");
        n = sc.nextInt();
        int []ar;

        int []days = new int[n];
        System.out.println("Enter the stock values: ");
        for (int i = 0 ; i < n; i++) {
            days[i] = sc.nextInt();
        }

        ar = stockSpan(days);
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i - ar[i];
            System.out.print(ar[i] + " ");
        }
    }
}
