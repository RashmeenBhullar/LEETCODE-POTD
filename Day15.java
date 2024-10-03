
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // The remainder we need to remove
        int remainder = (int)(totalSum % p);
        if (remainder == 0) {
            return 0; // The sum is already divisible by p
        }
        
        // Use a HashMap to track prefix sums mod p
        Map<Integer, Integer> prefixModMap = new HashMap<>();
        prefixModMap.put(0, -1); // To handle subarrays starting from index 0
        int minLength = n;
        long prefixSum = 0;
        
        // Traverse through the array to find the smallest subarray to remove
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int currentMod = (int)(prefixSum % p);
            
            // Calculate the target mod we need
            int targetMod = (currentMod - remainder + p) % p;
            
            // Check if the target mod exists in the prefix map
            if (prefixModMap.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixModMap.get(targetMod));
            }
            
            // Update the prefix map with the current mod
            prefixModMap.put(currentMod, i);
        }
        
        // If we didn't find any valid subarray, return -1
        return minLength == n ? -1 : minLength;
    }
}
