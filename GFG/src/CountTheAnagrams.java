// Java program to count the number of anagrams in the string
// EX: str = "aabaabaa", ptr = "aaba"
// OP: 4

import java.util.HashMap;

public class CountTheAnagrams {

    static int countTheAnagrams(String str, String ptr) {
        int ans = 0, i = 0, j = 0, k = ptr.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for( int ch = 0; ch < k; ch++){
            map.put(ptr.charAt(ch), map.getOrDefault(ptr.charAt(ch), 0) + 1);
        }

        int counts = map.size();
//        aabacabaa
//        012345678

        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) - 1);
                if (map.get(str.charAt(j)) == 0)
                    counts--;
            }

            if (j - i + 1 == k){
                if (counts == 0)
                    ans++;

                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
                    if (map.get(str.charAt(i)) == 1)
                        counts++;
                }

                i++;
            }

            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("The number of anagrams are: " + countTheAnagrams("eidboaoo", "ab"));
    }

}
