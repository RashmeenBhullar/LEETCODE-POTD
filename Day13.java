class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Count the occurrences of each remainder
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handle negative numbers
            remainderCount[remainder]++;
        }
        
        // Check the pairing conditions
        // Remainder 0 must be even
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        
        // Check pairs of remainders
        for (int r = 1; r <= k / 2; r++) {
            if (remainderCount[r] != remainderCount[k - r]) {
                return false;
            }
        }
        
        return true;
    }
}
//leetcode
