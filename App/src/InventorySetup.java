/**
 * ===============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ===============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability
 * is managed using a centralized inventory.
 *
 * Room objects are used to retrieve pricing
 * and room characteristics.
 *
 * No booking or search logic is introduced here.
 *
 * @version 3.1
 */

public class InventorySetup {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status");
        System.out.println();

        // Create inventory manager
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Display Single Room Info
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single"));
        System.out.println();

        // Display Double Room Info
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double"));
        System.out.println();

        // Display Suite Room Info
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}