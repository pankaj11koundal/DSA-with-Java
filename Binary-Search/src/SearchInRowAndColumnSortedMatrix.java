import java.util.ArrayList;

public class SearchInRowAndColumnSortedMatrix {
    static ArrayList<Integer> searchInRowAndColumnSortedMatrix(int[][] arr, int n, int m, int key) {
        int i = 0, j = m - 1;
        ArrayList<Integer> ar = new ArrayList<>();

        while (i < n && j >= 0) {
            if (arr[i][j] == key) {
                ar.add(i);
                ar.add(j);
                return ar;
            } else if (arr[i][j] > key)
                j--;
            else
                i++;
        }
        ar.add(-1);
        return ar;
    }

    public static void main(String[] args) {
        int [][]arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int key = 10;
        System.out.println(searchInRowAndColumnSortedMatrix(arr, arr.length, arr[0].length, key));
    }
}
