public class BinaryExponentiation {
    static class Solution{
        public double myPow(double x, long n) {
            long nn = n;
            double ans = 1.0;

            if (nn < 0) nn = -1 * nn;

            while (nn > 0) {
                if (nn % 2 == 1) {
                    ans = ans * x;
                    nn = nn - 1;
                } else  {
                    x = x * x;
                    nn = nn / 2;
                }
            }

            if (n < 0) ans = 1.0 / ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 10, x = 2;
        Solution s = new Solution();

        System.out.print(s.myPow(x, n));
    }
}
