// Java program to print the permutation with case change
// EX: ab => ab, aB, Ab, AB

public class PermutationWithCaseChange {

    static void permutationWithCaseChange(String ip, String op) {
        if (ip.isEmpty())
            System.out.println(op);
        else {
            char ch = ip.charAt(0);
            ip = ip.substring(1);

            permutationWithCaseChange(ip, op + ch);
            permutationWithCaseChange(ip, op + Character.toUpperCase(ch));
        }
    }

    public static void main(String[] args) {
        permutationWithCaseChange("abc", "");
    }
}
