// Java Program to return the grammar generated at the nth and kth position.

public class GenerateGrammar {

    static boolean generateGrammar(int n, int k) {
        if (n == 1 && k == 1)
            return false;

        int mid = (int) Math.pow(2, n - 1) / 2;

        if (mid >= k)
            return generateGrammar(n - 1, k);
        else
            return !generateGrammar(n - 1,k - mid);
    }

    public static void main(String[] args) {
        System.out.print(generateGrammar(4, 6));
    }
}
