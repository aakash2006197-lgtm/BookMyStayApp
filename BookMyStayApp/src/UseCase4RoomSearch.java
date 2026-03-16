/**
 * ==========================================================
 * MAIN CLASS – UseCase4RoomSearch
 * ==========================================================
 *
 * Use Case 4: Guest Room Search
 *
 * Demonstrates safe read-only access
 * to room availability through a search service.
 *
 * Inventory state is not modified.
 *
 * @version 4.1
 */

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Hotel Room Search Results\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search
        searchService.searchAvailableRooms(inventory);
    }
}