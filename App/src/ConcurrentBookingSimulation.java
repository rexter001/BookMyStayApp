public class ConcurrentBookingSimulation {

    public static void main(String[] args) {
        // 1. Initialize shared resources
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Simulate 10 guests submitting requests
        for (int i = 1; i <= 10; i++) {
            // FIXED: Added "Standard" as the second argument (roomType)
            bookingQueue.addRequest(new Reservation("Guest " + i, "Standard"));
        }

        // 3. Create two worker threads (t1 and t2)
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // 4. Start concurrent processing
        System.out.println("Starting concurrent booking processing...");
        t1.start();
        t2.start();

        try {
            // Wait for both threads to finish before the main program ends
            t1.join();
            t2.join();
            System.out.println("Execution complete. All threads have finished.");
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted.");
        }
    }
}
