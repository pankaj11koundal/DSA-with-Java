import java.util.ArrayList;
import java.util.List;

public class practice {

    static void listChange(List<Integer> l) {
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        l.add(1);
        System.out.println(l);
        listChange(l);
        System.out.println(l);
    }
}
