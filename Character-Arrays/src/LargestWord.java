import java.util.Scanner;

public class LargestWord {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int wordLength = 0, maxLength = 0;
        String string;

        System.out.println("Enter the characters in the character array :");
        string = sc.nextLine();
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == ' '){
                maxLength = Integer.max(wordLength, maxLength);
                wordLength = 0;
            }
            else
                wordLength++;
//            System.out.print(string[i] + " ");

        maxLength = Integer.max(maxLength, wordLength);

        System.out.println("The length of the largest word is " + maxLength);
    }
}
