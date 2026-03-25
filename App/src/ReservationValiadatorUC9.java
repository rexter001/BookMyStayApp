public class ReservationValiadatorUC9 {

    public void validate(
            String guestName,
            String roomType,
            RoomInventoryUC9 inventory
    ) throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type (CASE-SENSITIVE)
        if (!roomType.equals("Single") &&
                !roomType.equals("Double") &&
                !roomType.equals("Suite")) {

            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Check availability
        if (inventory.getAvailableRooms(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for selected type.");
        }
    }
}