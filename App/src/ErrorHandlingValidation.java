import java.util.Scanner;

public class ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventoryUC9 inventory = new RoomInventoryUC9();
        ReservationValiadatorUC9 validator = new ReservationValiadatorUC9();
        BookingRequestQueueUC9 queue = new BookingRequestQueueUC9();

        try {

            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate
            validator.validate(guestName, roomType, inventory);

            // Process booking
            inventory.bookRoom(roomType);
            queue.addRequest(guestName + " booked " + roomType);

            System.out.println("Booking successful!");

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}