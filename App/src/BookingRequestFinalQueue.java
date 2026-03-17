/**
 * ===============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ===============================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class demonstrates how booking
 * requests are accepted and queued
 * in a fair and predictable order.
 *
 * No room allocation or inventory
 * update is performed here.
 *
 * @version 5.0
 */

public class BookingRequestFinalQueue {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Display application header
        System.out.println("Booking Request Queue");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process booking requests in FIFO order.
        while (bookingQueue.hasPendingRequests()) {

            Reservation nextRequest = bookingQueue.getNextRequest();

            System.out.println(
                    "Processing booking for Guest: "
                            + nextRequest.getGuestName()
                            + ", Room Type: "
                            + nextRequest.getRoomType()
            );
        }
    }
}