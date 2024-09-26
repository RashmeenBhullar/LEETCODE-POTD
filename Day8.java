class MyCalendar {
    private List<int[]> bookings;

    // Constructor
    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    // Method to book an event
    public boolean book(int start, int end) {
        // Check for any overlap with existing bookings
        for (int[] booking : bookings) {
            // Check if the new booking overlaps with the current booking
            if (start < booking[1] && end > booking[0]) {
                return false; // Conflict found
            }
        }
        // No conflicts, add the new booking
        bookings.add(new int[]{start, end});
        return true; // Booking successful
    }

    // Main method for testing
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        
        System.out.println(myCalendar.book(10, 20)); // Output: true
        System.out.println(myCalendar.book(15, 25)); // Output: false
        System.out.println(myCalendar.book(20, 30)); // Output: true
    }
}//leetcode