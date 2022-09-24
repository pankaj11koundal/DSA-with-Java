public class PalindromePartitioningOptimized {
    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    static int findPalindromePartitioning(String str, int[][] t, int i, int j) {
        if (i >= j) return 0;

        if (isPalindrome(str, i, j)) return 0;
        if (t[i][j] != -1) return t[i][j];

        int ans = Integer.MAX_VALUE, ansTemp, left, right;

        for (int k = i; k <= j - 1; k++) {
            if (t[i][k] != -1)  left = t[i][k]; else left = findPalindromePartitioning(str, t, i, k);
            if (t[k + 1][j] != -1) right = t[k + 1][j]; else right = findPalindromePartitioning(str, t,k + 1, j);

            ansTemp = left + right + 1;

            ans = Math.min(ans, ansTemp);
        }

        return t[i][j] =  ans;
    }
    static int palindromePartitioning(String str) {
        int[][] t = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++)
            for (int j = 0; j < str.length(); j++)
                t[i][j] = -1;

        return findPalindromePartitioning(str, t, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromePartitioning(str));
    }
}
