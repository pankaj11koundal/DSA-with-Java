public class AllocateMinimumNumberOfPages {

    static int[] maxSumPage(int[] arr) {
        int []page = new int[2];
        page[1] = Integer.MIN_VALUE;
        for (int value : arr) {
            page[0] += value;
            page[1] = Math.max(page[1], value);
        }
        return page;
    }

    static boolean isValid(int[] arr, int n, int k, int mid) {
        int student = 1;
        int sum = 0;

        for (int value : arr) {
            sum += value;
            if (sum > mid) {
                student++;
                sum = value;
            }

            if (student > k)
                return false;
        }

        return true;
    }

    static int findPages(int []A, int N, int M) {
        int [] maxSum = maxSumPage(A);
        int start = maxSum[1], end = maxSum[0];
        int res = -1, mid;
        if (A.length >= M) {
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (isValid(A, N, M, mid)) {
                    res = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] books = {24, 31, 71};
        int k = 3, n = books.length;
        System.out.println(findPages(books, n, k));
    }
}
