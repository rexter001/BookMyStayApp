import java.util.*;

public class RoomInventoryUC10 {

    private Map<String, Integer> rooms;

    public RoomInventoryUC10() {
        rooms = new HashMap<>();

        rooms.put("Single", 5);   // initial so after cancel → 6
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }

    public void incrementRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) + 1);
    }
}