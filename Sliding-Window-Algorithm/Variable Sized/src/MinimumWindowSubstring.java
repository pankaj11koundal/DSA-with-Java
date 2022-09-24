import java.util.HashMap;

public class MinimumWindowSubstring {
    static int minimumWindowSubString(String s, String t){
        if (s.length() >= t.length()) {
            int ans = Integer.MAX_VALUE;
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0) + 1);
            }

            System.out.println(map);

            int i = 0, j = 0, count = map.size(), size = s.length();

            while (j < size) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);

                    if (map.getOrDefault(s.charAt(j), 0) == 0)
                        count--;

                    while (count == 0) {
                        if (map.containsKey(s.charAt(i))) {
                            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

                            if (map.get(s.charAt(i)) == 1) {
                                count++;
                            }
                            ans = Integer.min(ans, j - i + 1);
                        }
                        i++;
                    }
                }
                j++;
            }

            return (ans);
        } else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumWindowSubString("ADOBECODEBANC", "ABC"));
    }
}
