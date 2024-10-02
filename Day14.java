class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Create a copy of the original array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Create a hash map to store the rank of each unique number
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        // Assign ranks to each unique number
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }
        
        // Replace elements in the original array with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}