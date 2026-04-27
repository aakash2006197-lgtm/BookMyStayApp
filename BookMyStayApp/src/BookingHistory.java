import java.util.*;

public class BookingHistory {

    // Stores confirmed bookings in order
    private List<Reservation> confirmedBookings;

    public BookingHistory() {
        confirmedBookings = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedBookings.add(reservation);
    }

    // Get all bookings
    public List<Reservation> getAllReservations() {
        return confirmedBookings;
    }
}