public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        // Continue processing as long as there are requests in the queue
        while (true) {
            Reservation reservation = null;

            // CRITICAL SECTION 1: Accessing the shared Queue
            synchronized (bookingQueue) {
                if (bookingQueue.hasPendingRequests()) {
                    break; // Exit the loop and thread if no more requests
                }
                reservation = bookingQueue.getNextRequest();
            }

            if (reservation != null) {
                // CRITICAL SECTION 2: Accessing the shared Inventory
                synchronized (inventory) {
                    // This ensures only one thread updates room counts at a time
                    allocationService.allocateRoom(reservation, inventory);
                }
            }
        }
    }
}