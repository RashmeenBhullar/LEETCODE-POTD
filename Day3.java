class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(result, i, n);
        }
        return result;
    }
    
    private void dfs(List<Integer> result, int current, int n) {
        if (current > n) {
            return;
        }
        result.add(current);
        for (int i = 0; i <= 9; i++) {
            dfs(result, current * 10 + i, n);
        }
    }
}//leetcode