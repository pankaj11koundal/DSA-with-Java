public class PalindromePartitioningRecursion {
    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    static int findPalindromePartitioning(String str, int i, int j) {
        if (i >= j) return 0;

        if (isPalindrome(str, i, j)) return 0;

        int ans = Integer.MAX_VALUE, ansTemp;

        for (int k = i; k <= j - 1; k++) {
            ansTemp = findPalindromePartitioning(str, i, k) + findPalindromePartitioning(str, k + 1, j) + 1;

            ans = Math.min(ans, ansTemp);
        }

        return ans;
    }
    static int palindromePartitioning(String str) {
        return findPalindromePartitioning(str, 0, str.length() - 1);
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(palindromePartitioning(str));
    }
}
