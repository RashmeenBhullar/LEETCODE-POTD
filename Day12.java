class CustomStack {
    private int[] stack;
    private int[] incrementArray;
    private int maxSize;
    private int top;
    
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize]; // array to store elements in the stack
        this.incrementArray = new int[maxSize]; // array to store increment values
        this.maxSize = maxSize;
        this.top = -1; // the top pointer of the stack
    }
    
    // Adds x to the top of the stack if the stack has not reached the maxSize
    public void push(int x) {
        if (top + 1 < maxSize) {
            top++;
            stack[top] = x;
        }
    }
    
    // Pops and returns the top of the stack, or -1 if the stack is empty
    public int pop() {
        if (top == -1) {
            return -1; // stack is empty
        }
        int poppedValue = stack[top] + incrementArray[top]; // apply any increment to the top element
        if (top > 0) {
            incrementArray[top - 1] += incrementArray[top]; // propagate increment value to the next element below
        }
        incrementArray[top] = 0; // reset increment for the popped element
        top--;
        return poppedValue;
    }
    
    // Increments the bottom k elements of the stack by val
    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1); // handle case where k is greater than the stack size
        if (limit > 0) {
            incrementArray[limit - 1] += val; // add increment to the bottom k elements
        }
    }
}

