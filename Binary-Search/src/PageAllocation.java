public class PageAllocation {
    static int[] maxSumPage(int[] arr) {
        int []page = new int[2];
        page[1] = Integer.MIN_VALUE;
        for (int value : arr) {
            page[0] += value;
            page[1] = Math.max(page[1], value);
        }
        return page;
    }

    static boolean isValid(int[] arr, int k, int mid) {
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

    static int allocateMinimumPage(int []books, int k) {
        int [] maxSum = maxSumPage(books);
        int start = maxSum[1], end = maxSum[0];
        int res = -1, mid;
        if (books.length > k) {
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (isValid(books, k, mid)) {
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
        int [] books = {10, 20, 30, 40};
        int k = 5;
        System.out.println(allocateMinimumPage(books, k));
    }
}
