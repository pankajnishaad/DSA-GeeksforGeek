class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int limit = x + l;
        int[] dp = new int[limit + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        // Build minimum cost for every achievable area.
        for (int i = 0; i <= limit; i++) {

            if (dp[i] == Integer.MAX_VALUE)
                continue;

            if (i + s <= limit)
                dp[i + s] = Math.min(dp[i + s], dp[i] + cs);

            if (i + m <= limit)
                dp[i + m] = Math.min(dp[i + m], dp[i] + cm);

            if (i + l <= limit)
                dp[i + l] = Math.min(dp[i + l], dp[i] + cl);
        }

        // Find the minimum cost for an area of at least x.
        int res = Integer.MAX_VALUE;

        for (int i = x; i <= limit; i++)
            res = Math.min(res, dp[i]);

        return res;        
    }
}