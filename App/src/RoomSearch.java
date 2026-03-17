/**
 * ===============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ===============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests
 * can view available rooms without
 * modifying inventory data.
 *
 * The system enforces read-only access
 * by design and usage discipline.
 *
 * @version 4.0
 */

public class RoomSearch {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Create search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}