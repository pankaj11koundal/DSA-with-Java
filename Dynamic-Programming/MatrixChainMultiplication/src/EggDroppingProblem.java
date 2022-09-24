public class EggDroppingProblem {
    static int eggDropping(int e, int f) {
        if (f == 0 || f == 1) return f;

        if (e == 1) return f;

        int ans = Integer.MAX_VALUE, tempAns;
        for (int k = 1; k <= f; k++) {
            tempAns = 1 + Math.max(eggDropping(e - 1, k - 1), eggDropping(e, f - k));

            ans = Math.min(ans, tempAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        int f = 5, e = 3;
        System.out.println(eggDropping(e, f));
    }
}
