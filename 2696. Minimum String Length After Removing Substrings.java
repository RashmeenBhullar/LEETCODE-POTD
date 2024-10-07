class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                // Check for "AB" or "CD" pattern
                if ((top == 'A' && c == 'B') || (top == 'C' && c == 'D')) {
                    stack.pop(); // Remove the "AB" or "CD" pair
                } else {
                    stack.push(c); // Push the character if no pair is formed
                }
            } else {
                stack.push(c); // Push the first character
            }
        }
        
        // The remaining characters in the stack form the minimized string
        return stack.size();
    }
}