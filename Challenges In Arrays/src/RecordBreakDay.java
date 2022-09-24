// A day is record breaker if it satisfies the following conditions:
// 1) The number of visitors on the day is strictly larger than the number of visitor on each of the previous day.
// 2) Either it is the last day.

import java.util.Scanner;

public class RecordBreakDay {

    static Scanner sc = new Scanner(System.in);

    static int findRecordBreakDay(int[] visitors)
    {
        int day;
        if (visitors.length == 1){
            return visitors[0];
        }

        day = visitors[0];

        for (int i = 1; i < visitors.length; i++)
        {
            if (visitors[i] > day)
                day = visitors[i];
        }

        return day;
    }

    public static void main(String[] args) {
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int[] visitors = new int[size];
        System.out.print("Enter the visitors in each day: ");
        for (int i = 0; i < size; i++)
            visitors[i] = sc.nextInt();

        System.out.println("The record breaker day is " + findRecordBreakDay(visitors));
    }

}
