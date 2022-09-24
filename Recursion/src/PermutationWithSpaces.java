// Java program to print the permutation with spaces
// EX: "abc": "abc", "a bc", "ab c", "a b c"

public class PermutationWithSpaces {

    static void permutationWithSpaces(String ip, String op) {
        if (ip.length() == 1)
            System.out.println(op + ip);
        else {
            op += ip.charAt(0);
            ip = ip.substring(1);

            permutationWithSpaces(ip, op);
            permutationWithSpaces(ip, op + " ");
        }
    }

    public static void main(String[] args) {
        permutationWithSpaces("abcd", "");
    }
}
