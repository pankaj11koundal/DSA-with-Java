// Java program to print all the unique substrings

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubstring {

    static void printUniqueSubstrings(String ip, String op, Set<String> unique) {
        if (ip.equals("")) {
            unique.add(op);
        } else {
            char ch = ip.charAt(0);
            ip = ip.substring(1);
            printUniqueSubstrings(ip, op, unique);
            printUniqueSubstrings(ip, op + ch, unique);
        }
    }

    public static void main(String[] args) {
        Set<String> unique = new HashSet<>();
        printUniqueSubstrings("aab", "", unique);

        for (String str: unique) {
            System.out.println(str);
        }
    }
}
