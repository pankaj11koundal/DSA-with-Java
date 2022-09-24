// Java program to implement the joseph problem

import java.util.Scanner;
import java.util.ArrayList;

public class JosephProblem {

    static Scanner sc = new Scanner(System.in);

    static int josephProblem(ArrayList<Integer> arr, int index, int k) {
        if (arr.size() == 1)
            return arr.get(0);
        else {
            index = (index + k) % arr.size();
            arr.remove(index);

            return josephProblem(arr, index, k);
        }
    }

    public static void main(String[] args) {
        int n, k;
        System.out.println("Enter the number of elements and value of k respectively: ");
        n = sc.nextInt();
        k = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }

        System.out.println(josephProblem(arr,0, k - 1));
    }
}
