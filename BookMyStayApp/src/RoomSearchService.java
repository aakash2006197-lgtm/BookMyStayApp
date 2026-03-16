import java.util.Map;

/**
 * ==========================================================
 * CLASS – RoomSearchService
 * ==========================================================
 *
 * Use Case 4: Guest Room Search
 *
 * Description:
 * Provides read-only access to room availability
 * and displays available room options to guests.
 *
 * Inventory state is never modified here.
 *
 * @version 4.1
 */

public class RoomSearchService {

    /**
     * Displays available rooms based on inventory.
     * Only rooms with availability > 0 are shown.
     */
    public void searchAvailableRooms(RoomInventory inventory) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms\n");

        // Single Room
        if (availability.get("Single") > 0) {
            Room single = new SingleRoom();
            System.out.println("Single Room:");
            single.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Single"));
            System.out.println();
        }

        // Double Room
        if (availability.get("Double") > 0) {
            Room dbl = new DoubleRoom();
            System.out.println("Double Room:");
            dbl.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Double"));
            System.out.println();
        }

        // Suite Room
        if (availability.get("Suite") > 0) {
            Room suite = new SuiteRoom();
            System.out.println("Suite Room:");
            suite.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Suite"));
            System.out.println();
        }
    }
}