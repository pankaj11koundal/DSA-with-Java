import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    static int findLargestSubstringWithoutRepeatingChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = Integer.MIN_VALUE;

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() < j - i + 1) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.getOrDefault(s.charAt(i), 0) == 0)
                    map.remove(s.charAt(i));
                i++;
            }

            if (map.size() == j - i + 1)
                ans = Integer.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findLargestSubstringWithoutRepeatingChars("bbbbb"));
    }
}
