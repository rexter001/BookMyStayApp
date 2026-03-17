/**
 * ===============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ===============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */

public class RoomAllocationServiceFinal {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Initialize allocation service
        RoomAllocationService allocationService =
                new RoomAllocationService();

        // Process booking requests
        while (bookingQueue.hasPendingRequests()) {

            Reservation request = bookingQueue.getNextRequest();

            allocationService.allocateRoom(request, inventory);
        }
    }
}