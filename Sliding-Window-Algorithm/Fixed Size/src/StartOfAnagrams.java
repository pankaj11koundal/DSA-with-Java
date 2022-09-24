import java.util.HashMap;
import java.util.ArrayList;

public class StartOfAnagrams {
    static ArrayList<Integer> countTheAnagrams(String str, String ptr) {
        int i = 0, j = 0, k = ptr.length();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

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
                    arr.add(i);

                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
                    if (map.get(str.charAt(i)) == 1)
                        counts++;
                }

                i++;
            }

            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(countTheAnagrams("forxxorfxdofr", "for"));
    }
}
