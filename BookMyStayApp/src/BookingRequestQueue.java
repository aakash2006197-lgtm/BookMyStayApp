import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<BookingRequest> queue = new LinkedList<>();

    // Add request (Producer)
    public synchronized void addRequest(BookingRequest request) {
        queue.add(request);
        notify(); // Wake up waiting threads
    }

    // Get request (Consumer)
    public synchronized BookingRequest getRequest() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait until request arrives
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return queue.poll();
    }
}