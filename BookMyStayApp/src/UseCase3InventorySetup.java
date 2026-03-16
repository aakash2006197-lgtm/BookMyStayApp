import java.util.Map;

/**
 * ==========================================================
 * MAIN CLASS – UseCase3InventorySetup
 * ==========================================================
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

public class UseCase3InventorySetup {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Single"));

        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Double"));

        System.out.println();

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Suite"));
    }
}