// Java program to implement the tower of hanoi

import java.util.Scanner;

public class TowerOfHanoi {
    static Scanner sc = new Scanner(System.in);

    static void towerOFHanoi(int n, int source, int destination, int helper) {
        if (n == 1) {
            System.out.println("Move plate " + n + " from " + source + " to " + destination);
        }
        else {
            towerOFHanoi(n - 1, source, helper, destination);
            System.out.println("Move plate" + n + " from " + source + " to " + destination);
            towerOFHanoi(n - 1, helper, destination, source);
        }
    }

    public static void main(String[] args) {
        int n;
        System.out.print("Enter the number of plates: ");
        n = sc.nextInt();
        int source = 1, helper = 2, destination = 3;
        towerOFHanoi(n,source, destination, helper);
    }
}
