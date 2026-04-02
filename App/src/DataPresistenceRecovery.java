public class DataPresistenceRecovery {

    private static final String STORAGE_FILE = "inventory_state.ser";

    public static void main(String[] args) {
        FilePresistenceService persistenceService = new FilePresistenceService();
        InventorySetup inventory;

        System.out.println("System Recovery");

        // 1. Attempt to Load
        inventory = persistenceService.loadInventory(STORAGE_FILE);

        if (inventory == null) {
            System.out.println("No valid inventory data found. Starting fresh.\n");
            // Initialize with default values if no save file exists
            inventory = new InventorySetup();
            inventory.initializeInventory(5, 3, 2);
        } else {
            System.out.println("Inventory restored from previous state.\n");
        }

        // 2. Display Current State
        System.out.println("Current Inventory:");
        inventory.displayInventory();

        // 3. Save State (Simulating shutdown preparation)
        persistenceService.saveInventory(inventory, STORAGE_FILE);
    }
}