class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int unmatchedClosing = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '[') { 
            } else {
                balance--; 
            }
            
   
            if (balance < 0) {
                unmatchedClosing++;  
                balance = 0;  
            }
        }
        
      
        return (unmatchedClosing + 1) / 2;
    }
}
