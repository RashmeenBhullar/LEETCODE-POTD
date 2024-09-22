class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1; // Start from 1
        k--; // Decrement k to account for the current prefix
        
        while (k > 0) {
            int count = getCount(current, n);
            if (count <= k) {
                // If count of numbers starting with current is less than or equal to k
                // Move to the next prefix
                current++;
                k -= count; // Decrease k by the count of numbers skipped
            } else {
                // If count is greater than k, move to the next level in the trie
                current *= 10; // Go deeper in the tree
                k--; // Use one count for the current prefix
            }
        }
        
        return current; // Return the kth number
    }
    
    private int getCount(int prefix, int n) {
        long current = prefix;
        long next = prefix + 1;
        int count = 0;
        
        while (current <= n) {
            count += Math.min(n + 1, next) - current; // Count numbers in range
            current *= 10; // Move to the next level
            next *= 10; // Move to the next level
        }
        
        return count; // Return the total count of numbers starting with prefix
    }
}//leet