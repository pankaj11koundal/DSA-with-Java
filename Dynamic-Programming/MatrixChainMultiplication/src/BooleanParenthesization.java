public class BooleanParenthesization {
    static int findways(String str, int i, int j, boolean isTrue) {
        if (i > j) return 1;

        if (i == j) {
            if (isTrue)
                if (str.charAt(i) == 'T') return 1; else return 0;
            else
                if (str.charAt(i) == 'F') return 1; else return 0;
        }
        int ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lT = findways(str, i, k - 1, true);
            int lF = findways(str, i, k - 1, false);
            int rT = findways(str, k + 1, j, true);
            int rF = findways(str, k + 1, j, false);

            if (str.charAt(k) == '&') {
                if (isTrue)
                    ans += lT * rT;
                else
                    ans += (lF * rF) + (lF * rT) + (rF * lT);
            } else if (str.charAt(k) == '|') {
                if (isTrue)
                    ans += (lT * rT) + (rT * lF) + (lF * rT);
                else
                    ans += rF * lF;
            } else if (str.charAt(k) == '^') {
                if (isTrue)
                    ans += (lF * rT) + (rF * lT);
                else
                    ans += (lF * rF) + (rT * lT);
            }
        }

        return ans;
    }
   static int booleanParenthesization(int n, String str) {
       return findways(str, 0, n - 1, true);
   }

    public static void main(String[] args) {
        String str = "T|T&F^T";
        System.out.println(booleanParenthesization(str.length(), str));
    }
}
