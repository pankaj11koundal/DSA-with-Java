//Java Program to implement the stock span Problem
// Find out the number of consecutive days before where the stock value is less than today
// [100, 80, 60, 70, 60, 75, 85] = [1, 1, 1, 2, 1, 4, 5]

import java.util.Stack;

public class StockSpanProblem {

    static class Stock {
        int value;
        int index;

        Stock(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static int[] stockSpan(int[] price, int n) {
        int []ar = new int[price.length];
        Stack<Stock> st = new Stack<>();
        Stock s = new Stock(price[0], 0);
        ar[0] = -1;
        st.push(s);

        for (int i = 1 ; i < n; i++) {
            while (!st.empty() && price[i] >= st.peek().value)
                st.pop();

            if (st.empty())
                ar[i] = -1;
            else
                ar[i] = st.peek().index;

            s = new Stock(price[i], i);
            st.push(s);
        }
        return ar;
    }

    public static void main(String[] args) {
        int n = 7;
        int []days = {100, 80, 60, 70, 60, 75, 85};

        int []ar;

        ar = stockSpan(days, n);
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i - ar[i];
            System.out.print(ar[i] + " ");
        }
    }
}
