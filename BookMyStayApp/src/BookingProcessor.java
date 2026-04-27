class BookingProcessor extends Thread {

    private BookingRequestQueue queue;
    private RoomInventory inventory;

    public BookingProcessor(BookingRequestQueue queue, RoomInventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            BookingRequest request = queue.getRequest();

            boolean success = inventory.bookRoom(request.roomType);

            if (success) {
                System.out.println(Thread.currentThread().getName() +
                        " booked " + request.roomType +
                        " for " + request.guestName);
            } else {
                System.out.println(Thread.currentThread().getName() +
                        " FAILED booking for " + request.guestName +
                        " (No rooms)");
            }
        }
    }
}