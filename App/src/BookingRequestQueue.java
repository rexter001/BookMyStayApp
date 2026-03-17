import java.util.LinkedList;
import java.util.Queue;

/**
 * ===============================================================
 * CLASS - BookingRequestQueue
 * ===============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class manages booking requests
 * using a queue to ensure fair allocation.
 *
 * Requests are processed strictly.
 * in the order they are received.
 *
 * @version 5.0
 */

public class BookingRequestQueue {

    /** Queue that stores booking requests. */
    private Queue<Reservation> requestQueue;

    /** Initializes an empty booking queue. */
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Adds a booking request to the queue.
     *
     * @param reservation booking request
     */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /**
     * Retrieves and removes the next
     * booking request from the queue.
     *
     * @return next reservation request
     */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Checks whether there are
     * pending booking requests.
     *
     * @return true if queue is not empty
     */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}