public class MatrixMultiplicationRecursion {

    static int matrixMultiplication(int[] dim, int i, int j) {
        if (i >= j)
            return 0;

        int ans = Integer.MAX_VALUE;
        int tempAns;
        for (int k = i; k <= j - 1; k++) {
            tempAns = matrixMultiplication(dim, i, k) + matrixMultiplication(dim, k + 1, j) +
                    dim[i - 1] * dim[k] * dim[j];

            ans = Math.min(ans, tempAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] dim = {40, 20, 30, 10, 30};

        System.out.println(matrixMultiplication(dim, 1, dim.length - 1));
    }
}
