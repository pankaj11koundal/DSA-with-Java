import java.util.HashMap;

public class ScrambleStringMemoization {
    static HashMap<String, Boolean> map = new HashMap<>();
    static boolean solve(String a, String b) {
        int n = a.length();

        if (a.equals(b)) return true;

        if (a.length() <= 1) return false;

        String key = a + " " + b;
        if (map.containsKey(key)) return map.get(key);

        for (int i = 1; i <= n - 1; i++) {
            if ((solve(a.substring(0, i), b.substring(n - i, n)) && solve(a.substring(i, n), b.substring(0, n - i))) ||
                    (solve(a.substring(0, i), b.substring(0, i)) && solve(a.substring(i, n), b.substring(i, n)))) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }

    static boolean scrambledString(String a, String b) {
        if (a.length() != b.length()) return false;
        return solve(a, b);
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgate";

        System.out.println(scrambledString(a, b));
    }
}
