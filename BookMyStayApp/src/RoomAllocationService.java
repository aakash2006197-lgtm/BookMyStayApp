import java.util.*;

class RoomAllocationService {

    // Stores all allocated room IDs to ensure uniqueness
    private Set<String> allocatedRoomIds;

    // Stores assigned room IDs grouped by room type
    private Map<String, Set<String>> assignedRoomsByType;

    // Counter for generating unique IDs
    private Map<String, Integer> roomCounters;

    // Constructor
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
        roomCounters = new HashMap<>();
    }

    // Allocates room and confirms reservation
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        // Check availability
        if (!inventory.isAvailable(roomType)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store globally (prevents duplicates)
        allocatedRoomIds.add(roomId);

        // Store by type
        assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
        assignedRoomsByType.get(roomType).add(roomId);

        // Update inventory immediately
        inventory.decrement(roomType);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    // Generates unique room ID
    private String generateRoomId(String roomType) {

        int count = roomCounters.getOrDefault(roomType, 0) + 1;
        roomCounters.put(roomType, count);

        String roomId = roomType + "-" + count;

        // Extra safety (though counter already ensures uniqueness)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomCounters.put(roomType, count);
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}