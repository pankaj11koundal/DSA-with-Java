// Java program to implement the printing of substring using the recursion

public class PrintSubsetOfGivenString {

    static void printSubString(String ip, String op){
        if (ip.equals(""))
            System.out.print(op + " ");
        else {
            char ch = ip.charAt(0);
            ip = ip.substring(1);
            printSubString(ip, op);
            printSubString(ip, op + ch);
        }
    }

    public static void main(String[] args) {
        printSubString("abc", "");
    }
}
