import java.io.*;
import java.util.*;

// Inventory Model (Serializable)
class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> rooms;

    public Inventory() {
        rooms = new HashMap<>();
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Integer> rooms) {
        this.rooms = rooms;
    }

    public void display() {
        System.out.println("\nCurrent Inventory:");
        for (String type : rooms.keySet()) {
            System.out.println(type + ": " + rooms.get(type));
        }
    }
}

// Persistence Service
class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    // SAVE (Serialization)
    public static void saveInventory(Inventory inventory) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    // LOAD (Deserialization)
    public static Inventory loadInventory() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (Inventory) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No valid inventory data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Corrupted data. Starting with new inventory.");
        }

        return new Inventory(); // fallback
    }
}

// MAIN CLASS
public class UseCase12DataPersistenceRecovery {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        System.out.println("System Recovery");

        // Load inventory from file
        Inventory inventory = PersistenceService.loadInventory();

        // Display current state
        inventory.display();

        // Simulate system shutdown → save state
        PersistenceService.saveInventory(inventory);
    }
}