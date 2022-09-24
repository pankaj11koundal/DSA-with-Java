public class ReverseAString {
    public static void main(String[] args) {
        char []s = new char[]{'h', 'e', 'l', 'l', 'o'};

        char ch;
        int i = 0, j = s.length - 1;
        while(i < j) {
            ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        for (Character c: s)
            System.out.print(c);
    }
}
