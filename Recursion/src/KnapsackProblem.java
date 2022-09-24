// Given n items, each item has a certain value and weight. We have to maximize the value of objects, we can accommodate
// in a bag of weight W.

import java.util.Scanner;

public class KnapsackProblem {
    static Scanner sc = new Scanner(System.in);

    static int knapsack(int[] weights, int[] values, int n, int W)
    {
        if (n == 0 || W == 0)
            return 0;

        if (W < weights[n - 1])
            return knapsack(weights, values, n - 1, W);

        return Integer.max(knapsack(weights, values, n - 1, W),knapsack(weights, values, n - 1, W - weights[n-1]) + values[n - 1]);
    }


    public static void main(String[] args)
    {
        int W, n;
        System.out.print("Enter the Weight of the knapsack: ");
        W = sc.nextInt();

        System.out.print("Enter the number of items/objects: ");
        n = sc.nextInt();

        int []weights = new int[n];
        int []values = new int[n];
        System.out.println("Enter the weights of the objects/items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }


        System.out.println(knapsack(weights, values, n, W));
    }
}
