public class EggDroppingMemoization {
    static int eggDropping(int e, int f, int[][] t) {
        if (f == 0 || f == 1) return f;

        if (e == 1) return f;

        if (t[e][f] != -1) return t[e][f];

        int ans = Integer.MAX_VALUE, tempAns;
        for (int k = 1; k <= f; k++) {
            tempAns = 1 + Math.max(eggDropping(e - 1, k - 1, t), eggDropping(e, f - k, t));

            ans = Math.min(ans, tempAns);
        }

        return t[e][f] = ans;
    }

    public static void main(String[] args) {
        int f = 5, e = 3;
        int[][] t = new int[e + 1][f + 1];

        for (int i = 0; i <= e; i++) {
            for (int j = 0; j <= f; j++)
                t[i][j] = -1;
        }

        System.out.println(eggDropping(e, f, t));
    }
}
