import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
public class FilePresistenceService {



    /**
     * Saves the inventory state to a file.
     * @param inventory The HotelInventory object to save.
     * @param filePath The destination file path.
     */
    public void saveInventory(InventorySetup inventory, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Loads the inventory state from a file.
     * @param filePath The path to the persisted file.
     * @return The restored InventorySetup object, or null if file not found.
     */
    public InventorySetup loadInventory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null; // Handle missing file gracefully
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (InventorySetup) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
            return null;
        }
    }
}