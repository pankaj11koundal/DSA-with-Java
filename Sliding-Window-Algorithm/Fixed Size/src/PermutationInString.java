//  Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//In other words, return true if one of s1's permutations is the substring of s2.

import java.util.HashMap;

public class PermutationInString {
    static boolean findPermutationInString(String str, String ptr) {
        int i = 0, j = 0, k = ptr.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for( int ch = 0; ch < k; ch++){
            map.put(ptr.charAt(ch), map.getOrDefault(ptr.charAt(ch), 0) + 1);
        }

        int counts = map.size();
        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) - 1);
                if (map.get(str.charAt(j)) == 0)
                    counts--;
            }

            if (j - i + 1 == k){
                if (counts == 0)
                    return true;

                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
                    if (map.get(str.charAt(i)) == 1)
                        counts++;
                }

                i++;
            }

            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("The number of anagrams are: " + findPermutationInString("eidbaoo", "ab"));
    }
}
