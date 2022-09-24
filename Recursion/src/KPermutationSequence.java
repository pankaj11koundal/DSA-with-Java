import java.util.ArrayList;

public class KPermutationSequence {
    private static String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }

        numbers.add(n);
        k -= 1;
        String ans = "";
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);

            if (numbers.isEmpty())
                break;

            k /= fact;
            k %= fact;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 4, k = 17;
        System.out.println(getPermutation(n, k));
    }
}
