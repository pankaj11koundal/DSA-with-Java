public class PalindromePartitioning {
    static int ans = Integer.MAX_VALUE, part;

    private static boolean isPalindrome(String s, int index, int i) {

        int start = i, end = index;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))  return false;
            start ++;
            end --;
        }
        return true;
    }

    private static void palindromePartitioning(String s, int i, int part) {
        if (i == s.length()) {
            ans = Math.min(ans, part -  1);
        }
        else {
            for (int index = i; index < s.length(); index++) {
                if (isPalindrome(s, index, i)) {
                    part++;
                    palindromePartitioning(s, index + 1, part);
                    part--;
                }
            }
        }
    }

    public static void main(String[] args) {
        part = 0;

        palindromePartitioning("ababbbabbababa", 0, part);

        System.out.println(ans);
    }
}
