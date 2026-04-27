import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Booking Model
class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    String guestName;
    String roomType;

    public Booking(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return guestName + " -> " + roomType;
    }
}

// Inventory Model
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

    public void display() {
        System.out.println("\nCurrent Inventory:");
        for (String type : rooms.keySet()) {
            System.out.println(type + ": " + rooms.get(type));
        }
    }
}

// System State (Inventory + Bookings)
class SystemState implements Serializable {
    private static final long serialVersionUID = 1L;

    Inventory inventory;
    List<Booking> bookings;

    public SystemState(Inventory inventory, List<Booking> bookings) {
        this.inventory = inventory;
        this.bookings = bookings;
    }
}

// Persistence Service
class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // SAVE
    public static void save(SystemState state) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(state);
            System.out.println("Inventory & bookings saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // LOAD
    public static SystemState load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (SystemState) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No valid inventory data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Corrupted data detected. Starting fresh.");
        }
        return new SystemState(new Inventory(), new ArrayList<>());
    }
}

// MAIN CLASS
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        // Step 1: Load previous state
        SystemState state = PersistenceService.load();

        Inventory inventory = state.inventory;
        List<Booking> bookings = state.bookings;

        inventory.display();

        System.out.println("\nBooking History:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
        System.out.println("\nAdding new booking...");
        Booking newBooking = new Booking("Abhi", "Single");
        bookings.add(newBooking);

        // Update inventory safely
        Map<String, Integer> rooms = inventory.getRooms();
        if (rooms.get("Single") > 0) {
            rooms.put("Single", rooms.get("Single") - 1);
        }

        PersistenceService.save(new SystemState(inventory, bookings));
    }
}