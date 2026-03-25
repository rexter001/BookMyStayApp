public class AddOnServiceSelection {
    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Create manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Reservation ID
        String reservationId = "Single-1";

        // Create services
        Service breakfast = new Service("Breakfast", 500.0);
        Service spa = new Service("Spa", 1000.0);

        // Add services to reservation
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Calculate total cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        // Output
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
