class Solution {
    public int maxArea(int[][] mat) {
        // code here
            int n = mat.length;
            int m = mat[0].length;

            int[][] height = new int[n][m];

            // height[i][j] stores consecutive 1s ending at row i in column j.
            for (int j = 0; j < m; j++) {
                height[0][j] = mat[0][j];

                for (int i = 1; i < n; i++) {
                    if (mat[i][j] == 1) {
                        height[i][j] = height[i - 1][j] + 1;
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                int[] count = new int[n + 1];

                // Count frequency of each height.
                for (int j = 0; j < m; j++) {
                    count[height[i][j]]++;
                }

                int col = 0;

                // Rearrange heights in decreasing order using counting sort.
                for (int h = n; h >= 0; h--) {
                    while (count[h] > 0) {
                        height[i][col] = h;
                        col++;
                        count[h]--;
                    }
                }

                // Calculate maximum area for this row.
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, height[i][j] * (j + 1));
                }
            }

            return ans;    
    }
}