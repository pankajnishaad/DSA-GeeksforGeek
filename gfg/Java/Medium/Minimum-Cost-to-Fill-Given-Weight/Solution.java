class Solution {
    public int minimumCost(int[] cost, int w) {
        // code here
    int[] dp = new int[w + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            int n = cost.length;

            // base case
            dp[0] = 0;

            // Build the table dp[] in bottom up
            // manner and return the last entry
            for (int i = 1; i <= w; i++)
            {
                int min_cost = Integer.MAX_VALUE;

                for (int j = 0; j < n; j++)
                {
                    // cost[j] = -1 means unavailable
                    // j+1 is the weight of packet
                    if (cost[j] != -1 && (j + 1) <= i && dp[i - (j + 1)] != Integer.MAX_VALUE)
                    {
                        min_cost = Math.min(min_cost, cost[j] + dp[i - (j + 1)]);
                    }
                }

                dp[i] = min_cost;
            }

            // exactly weight w cannot be made
            return (dp[w] == Integer.MAX_VALUE) ? -1 : dp[w];    
    }
}