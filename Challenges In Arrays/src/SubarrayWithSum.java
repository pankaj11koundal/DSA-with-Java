// Given an unsorted array A of size N of non negative integers, find the continuous sub-array which adds to given
// number S

import java.util.Scanner;

public class SubarrayWithSum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int size = sc.nextInt(), i = 0, j = 0, count = 0, sum;
        int []arr = new int[size];

        for (int ptr = 0; ptr < size; ptr++)
            arr[ptr] = sc.nextInt();

        System.out.print("Enter the sum: ");
        sum = sc.nextInt();

        while(j < size){
            count += arr[j];

            if (count < sum)
                j++;
            else if (count > sum){
                count -= arr[i];
                i++;
            }

            if (sum == count)
                break;
        }

        System.out.println(i + " " + j);
    }
}
