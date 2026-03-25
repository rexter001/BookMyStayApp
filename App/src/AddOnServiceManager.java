import java.util.*;

public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services.
     *
     * Key   -> Reservation ID
     * Value -> List of selected services
     */
    private Map<String, List<Service>> servicesByReservation;

    /**
     * Initializes the service manager.
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attaches a service to a reservation.
     *
     * @param reservationId confirmed reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, Service service) {

        // If reservation doesn't exist, create a new list
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());

        // Add service to the list
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total add-on cost for a reservation.
     *
     * @param reservationId reservation ID
     * @return total service cost
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<Service> services = servicesByReservation.get(reservationId);

        if (services == null) {
            return 0.0;
        }

        double total = 0.0;

        for (Service s : services) {
            total += s.getCost();
        }

        return total;
    }
}