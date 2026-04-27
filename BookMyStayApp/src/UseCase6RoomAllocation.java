import java.util.*;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        // FIFO booking requests
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Suba", "Single"));
        bookingQueue.add(new Reservation("Vannathi", "Suite"));

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocator = new RoomAllocationService();

        System.out.println("Room Allocation Processing:\n");

        // Process queue
        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            allocator.allocateRoom(reservation, inventory);
        }
    }
}