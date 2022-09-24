import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private static boolean isPalindrome(String s, int index, int i) {

        int start = i, end = index;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))  return false;
            start ++;
            end --;
        }
        return true;
    }

    private static void palindromePartitioning(String s, int i, List<List<String>> res, List<String> part) {
        if (i == s.length()) {
            res.add(new ArrayList<>(part));
        }
        else {
            for (int index = i; index < s.length(); index++) {
                if (isPalindrome(s, index, i)) {
                    part.add(s.substring(i, index + 1));
                    palindromePartitioning(s, index + 1, res, part);
                    part.remove(part.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        palindromePartitioning("aabb", 0, res, part);

        System.out.println(res);
    }
}
