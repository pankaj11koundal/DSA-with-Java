import java.util.Scanner;

public class CircularSumSubArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();

        int [] arr = new int[size];
        System.out.print("Enter the elements in the array: ");
        for (int i=0; i < size; i++)
            arr[i] = sc.nextInt();

        int nonWrapSum = Kadane_sAlgorithm.kadane_sAlgorithm(arr);
        int totalSum = 0;
        for (int i = 0; i < size; i++){
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        System.out.println("Total Sum: " + totalSum);
        int wrapSum = totalSum + Kadane_sAlgorithm.kadane_sAlgorithm(arr);
        System.out.println(Integer.max(wrapSum, nonWrapSum));
    }
}
