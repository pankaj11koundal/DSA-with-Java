public class printShortestCommonSuperSequence {
    static String shortestCommonSuperSequence(int n, int m, String x, String y) {
        StringBuilder str = new StringBuilder();
        int [][] t = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            t[i][0] = 0;

        for (int j = 0; j <= m; j++)
            t[0][j] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }

        while (n > 0 && m > 0) {
            if (x.charAt(n - 1) == y.charAt(m - 1)) {
                str.append(x.charAt(n - 1));
                n--;
                m--;
            } else if (t[n][m - 1] > t[n - 1][m]) {
                str.append(y.charAt(m - 1));
                m--;
            } else {
                str.append(x.charAt(n - 1));
                n--;
            }
        }

        while (n > 0) {
            str.append(x.charAt(n - 1));
            n--;
        }

        while (m > 0) {
            str.append(y.charAt(m - 1));
            m--;
        }

        str.reverse();

        return str.toString();
    }

    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
        int n = x.length(), m = y.length();

        System.out.println(shortestCommonSuperSequence(n, m, x, y));
    }
}
