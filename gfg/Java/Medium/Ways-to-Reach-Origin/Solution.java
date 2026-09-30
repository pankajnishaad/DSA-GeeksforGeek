class Solution {
    public static long power(long base, long exp) {
            long res = 1;
            long mod = 1000000007;
            base = base % mod;

            while (exp > 0) {
                if (exp % 2 == 1) {
                    res = (res * base) % mod;
                }
                base = (base * base) % mod;
                exp /= 2;
            }
            return res;
        }
    public static long modInverse(long n) {
                return power(n, 1000000007 - 2);
            }
    public int ways(int x, int y) {
        // code here
        long mod = 1000000007;
                int n = x + y;
                int r = Math.min(x, y);
                long ans = 1;

                // Calculate nCr % mod
                for (int i = 1; i <= r; i++) {

                    // Multiply by (n - i + 1)
                    ans = (ans * (n - i + 1)) % mod;

                    // Divide by i using modular inverse
                    ans = (ans * modInverse(i)) % mod;
                }

                return (int)ans;
    }
}