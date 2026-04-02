import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ===============================================================
 * CLASS - InventorySetup
 * ===============================================================
 *
 * Used for persistence and recovery of inventory data
 *
 * @version 3.2
 */
public class InventorySetup implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory;

    public InventorySetup() {
        inventory = new HashMap<>();
    }

    public void initializeInventory(
            int single,
            int doubleRoom,
            int suite) {

        inventory.put("Single", single);
        inventory.put("Double", doubleRoom);
        inventory.put("Suite", suite);
    }

    public void displayInventory() {

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(
                    entry.getKey() + " -> " + entry.getValue()
            );
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}