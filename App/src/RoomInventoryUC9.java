import java.util.HashMap;
import java.util.Map;

public class RoomInventoryUC9 {

    private Map<String, Integer> rooms;

    public RoomInventoryUC9() {
        rooms = new HashMap<>();
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    public int getAvailableRooms(String roomType) {
        return rooms.getOrDefault(roomType, 0);
    }

    public void bookRoom(String roomType) {
        rooms.put(roomType, rooms.get(roomType) - 1);
    }
}