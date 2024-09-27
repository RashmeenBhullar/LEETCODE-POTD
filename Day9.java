class MyCalendarTwo {
    // List to store single bookings
    private List<int[]> singleBookings;
    // List to store double bookings
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
        singleBookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check against double bookings first
        for (int[] interval : doubleBookings) {
            if (start < interval[1] && end > interval[0]) {
                return false; // Conflict with double booking
            }
        }
        
        // Check against single bookings and prepare to add to double bookings
        for (int[] interval : singleBookings) {
            if (start < interval[1] && end > interval[0]) {
                doubleBookings.add(new int[] {Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }
        
        // Add the new booking to the single bookings
        singleBookings.add(new int[] {start, end});
        return true; // Booking successful
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */