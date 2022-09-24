// Java program to reverse the array using stack.

import java.util.ArrayList;
import java.util.Scanner;

public class SortArrayUsingRecursion {
    static Scanner sc = new Scanner(System.in);

    static void insertElement(ArrayList<Integer> arr, int ele) {
        if (arr.isEmpty() || arr.get(arr.size() - 1) <= ele) {
            arr.add(ele);
        }
        else {
            Integer temp = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            insertElement(arr, ele);
            arr.add(temp);
        }
    }

    static void sortArr(ArrayList<Integer> arr) {
        if (arr.size() > 1) {
            Integer ele = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
            sortArr(arr);
            insertElement(arr, ele);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++){
            arr.add(sc.nextInt());
        }

        sortArr(arr);

        System.out.println("After sorting the array: ");
        for (Integer element: arr) {
            System.out.print(element + " ");
        }
    }
}
