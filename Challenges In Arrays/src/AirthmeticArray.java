// An Arithmetic array is an array that contains atleast two
// integers and the difference between consecutive integers are equal
// Eg.
// [9, 10],
// [3, 3, 3],
// [9, 7, 5, 3]


import java.util.Scanner;

public class AirthmeticArray {
    static Scanner sc = new Scanner(System.in);
    static int start, end;

    static int largestArithmeticArray(int[] arr){
        int max = 0, count, var;

        for (int i = 0; i < arr.length - 1; i++){
            count = 0;
            var = Math.abs(arr[i + 1] - arr[i]);
            for (int j = i + 1; j < arr.length; j++){
                if (Math.abs(arr[j] - arr[j - 1]) == var) {
                    count++;
                }else {
                    start = i;
                    end = j;
                    i = j - 1;
                    break;
                }
            }

            if (count + 1 > max){
                max = count + 1;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int[] arr = new int[size];
        System.out.print("Enter the elements in the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(largestArithmeticArray(arr));

        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
