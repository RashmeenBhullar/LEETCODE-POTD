class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        
        // Initialize the dp array with a large value
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Starting point
        dp[0] = 0;
        
        // Fill the dp array
        for (int i = 0; i < n; i++) {
            // Check the next k stones
            for (int j = i + 1; j <= Math.min(n - 1, i + k); j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }
        
        // The minimum cost to reach the last stone
        return dp[n - 1];
    }
}
//gfg