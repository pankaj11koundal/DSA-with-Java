// Java program to implement the letterCaseDigitPermutation problem
// EX: "a1B2" => a1b2, a1B2, A1b2, A1B2

public class LetterCaseDigitPermutation {

    static void letterCaseDigitalPermutation(String ip, String op) {
        if (ip.isEmpty())
            System.out.println(op);
        else {
            char ch = ip.charAt(0);
            ip = ip.substring(1);

            if (Character.isDigit(ch))
                letterCaseDigitalPermutation(ip, op + ch);
            else {
                letterCaseDigitalPermutation(ip, op + Character.toLowerCase(ch));
                letterCaseDigitalPermutation(ip, op + Character.toUpperCase(ch));
            }
        }
    }

    public static void main(String[] args) {
        letterCaseDigitalPermutation("a1B2c", "");
    }
}
