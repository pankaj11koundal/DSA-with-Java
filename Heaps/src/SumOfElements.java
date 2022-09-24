import java.util.Arrays;

class SumOfElements {
    static long sumBetweenTwoKth(long[] A, long K1, long K2) {
        long result = 0;

        Arrays.sort(A);

        for (long l : A) {
            System.out.print(l + " ");
        }
        for (long i = K1 ; i < K2 - 1; i++)
            result += A[(int)i];

        return result;
    }

    public static void main(String[] args) {
        long []A = {20, 8, 22, 4, 12, 10, 14};
        long K1 = 3, K2 = 6;

        System.out.println(sumBetweenTwoKth(A, K1, K2));
    }
}